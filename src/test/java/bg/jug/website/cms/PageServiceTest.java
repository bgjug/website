package bg.jug.website.cms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import bg.jug.website.cms.model.Page;
import bg.jug.website.cms.repository.PageRepository;
import bg.jug.website.cms.service.PageService;

public class PageServiceTest {

	private Response response;
	private PageRepository pageRepositoryMock;
	private PageService pageService;
	private Page page;
	
	@Before
	public void setUp() {
		
		pageRepositoryMock = mock(PageRepository.class);
		page = new Page();
		page.setId(1L);
		when(pageRepositoryMock.findBy(Long.parseLong("1"))).thenReturn(page);
		pageService = new PageService(pageRepositoryMock);
	}
	
	@Test
	public void testCreateNonexistingPage() {

		Page newPage = new Page();
		response = pageService.createPage(newPage);

		verify(pageRepositoryMock).save(newPage);
		assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
	}

	
	@Test
	public void testCreateExistingPage() {
		
		response = pageService.createPage(page);
		
		verify(pageRepositoryMock, atLeastOnce()).save(page);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}

	@Test
	public void testUpdateExistingPage() {
		
		page.setTitle("TITLE");
		Page updatedPage = new Page();
		updatedPage.setId(1L);
		updatedPage.setTitle("title");
		when(pageRepositoryMock.save(page)).thenReturn(updatedPage);
		
		response = pageService.updatePage(page);
		
		verify(pageRepositoryMock).save(page);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		Page result = (Page) response.getEntity();
		assertEquals(result.getTitle(), "title");
		assertTrue(result.getId() == 1L);
	}


	@Test
	public void testUpdateNonexistingPage() {
		
		Page newPage = new Page();
		newPage.setId(3L);
		
		response = pageService.updatePage(newPage);
		assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
	}

	@Test
	public void testDeleteNonexistingPage() {
		
		response = pageService.deletePage("2");
		
		assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
		verify(pageRepositoryMock, never()).remove(page);
	}


	@Test
	public void testDeleteExistingPage() {
		response = pageService.deletePage("1");
		
		assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
		verify(pageRepositoryMock).remove(page);
	}
	
	@Test
	public void testFindNonexistingPage() {
		
		response = pageService.findPage("2");
		
		assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
	}

	
	@Test
	public void testFindExistingPage() {
		
		response = pageService.findPage("1");
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}
	
	@Test
	public void testAllPages() {
		
		response = pageService.allPages();
		ArrayList<?> allPages = (ArrayList<?>)response.getEntity();
		
		assertEquals(allPages.size(), 0);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		
		Page secondPage = new Page();
		secondPage.setId(2L);
		when(pageRepositoryMock.findAll()).thenReturn(Arrays.asList(page, secondPage));
		response = pageService.allPages();
		allPages = (ArrayList<?>)response.getEntity();
		
		assertEquals(allPages.size(), 2);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}
	
}
