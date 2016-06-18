package bg.jug.website.cms;

import static org.junit.Assert.assertEquals;
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

import bg.jug.website.model.cms.Page;

public class PageServiceTest {

	private Response response;
	private PageRepository pageRepositoryMock;
	private PageService pageService;
	private Page page;
	
	@Before
	public void setUp()
	{
		pageRepositoryMock = mock(PageRepository.class);
		page = new Page();
		page.setId(1L);
		when(pageRepositoryMock.findBy(Long.parseLong("1"))).thenReturn(page);
		pageService = new PageService(pageRepositoryMock);
	}
	
	@Test
	public void testCreatePage() {

		Page newPage = new Page();
		response = pageService.createPage(newPage);

		verify(pageRepositoryMock).save(newPage);
		assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
		
		response = pageService.createPage(page);
		
		verify(pageRepositoryMock, atLeastOnce()).save(page);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}

	@Test
	public void testUpdatePage(){
		
		response = pageService.updatePage("1");
		
		verify(pageRepositoryMock).findBy(1L);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		
		response = pageService.updatePage("2");
		
		verify(pageRepositoryMock).findBy(2L);
		assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
	}

	@Test
	public void testDeletePage(){
		
		response = pageService.deletePage("2");
		
		assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
		verify(pageRepositoryMock, never()).remove(page);

		response = pageService.deletePage("1");
		
		assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
		verify(pageRepositoryMock).remove(page);
	}
	
	@Test
	public void testFindPage(){
		
		response = pageService.findPage("2");
		
		assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
		
		response = pageService.findPage("1");
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}
	
	@Test
	public void testAllPages(){
		
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
