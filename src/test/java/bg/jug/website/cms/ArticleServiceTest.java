package bg.jug.website.cms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.repository.ArticleRepository;
import bg.jug.website.cms.service.ArticleService;
import bg.jug.website.cms.service.ArticleService.ArticleInfo;

public class ArticleServiceTest {

	private Response response;
	private ArticleRepository articleRepositoryMock;
	private ArticleService articleService;
	private Article article;

	@Before
	public void setUp() {

		articleRepositoryMock = mock(ArticleRepository.class);
		article = new Article();
		article.setId(1L);
		article.setCreatedDate(new Date());
		when(articleRepositoryMock.findBy(Long.parseLong("1"))).thenReturn(
				article);
		articleService = new ArticleService(articleRepositoryMock);
	}

	@Test
	public void testCreateNonexistingArticle() {

		Article newArticle = new Article();
		response = articleService.createArticle(newArticle);

		verify(articleRepositoryMock).save(newArticle);
		assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
	}

	@Test
	public void testCreateExistingArticle() {

		response = articleService.createArticle(article);

		verify(articleRepositoryMock, atLeastOnce()).save(article);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void testUpdateExistingArticle() {

		article.setTitle("TITLE");
		Article updatedArticle = new Article();
		updatedArticle.setId(1L);
		updatedArticle.setTitle("title");
		when(articleRepositoryMock.save(article)).thenReturn(updatedArticle);
		
		response = articleService.updateArticle(article);
		
		verify(articleRepositoryMock).save(article);
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		Article result = (Article) response.getEntity();
		assertEquals("title", result.getTitle());
		assertEquals(1L, result.getId().longValue());
	}


	@Test
	public void testUpdateNonexistingArticle() {
		
		Article newArticle = new Article();
		newArticle.setId(3L);
		
		response = articleService.updateArticle(newArticle);
		assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
	}

	@Test
	public void testDeleteNonxistingArticle() {

		response = articleService.deleteArticle("2");

		assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
		verify(articleRepositoryMock, never()).remove(article);

	}
	
	@Test
	public void testDeleteExistingArticle() {
		response = articleService.deleteArticle("1");

		assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
		verify(articleRepositoryMock).remove(article);
	}

	@Test
	public void testFindNonexistingArticle() {

		response = articleService.findArticle("2");

		assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}

	@Test
	public void testFindEexistingArticle() {

		response = articleService.findArticle("1");

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void testAllArticles() {

		response = articleService.allArticles();
		ArrayList<?> allArticles = (ArrayList<?>) response.getEntity();

		assertEquals(0, allArticles.size());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

		Article secondArticle = new Article();
		secondArticle.setId(2L);
		secondArticle.setCreatedDate(new Date());
		when(articleRepositoryMock.findAll()).thenReturn(
				Arrays.asList(article, secondArticle));
		response = articleService.allArticles();
		allArticles = (ArrayList<?>) response.getEntity();

		assertEquals(2, allArticles.size());
		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

		ArticleInfo firstArticleInfo = (ArticleInfo) allArticles.get(0);
		ArticleInfo secondArticleInfo = (ArticleInfo) allArticles.get(1);

		assertEquals(2L, firstArticleInfo.getId().longValue());
		assertEquals(1L, secondArticleInfo.getId().longValue());
	}

}
