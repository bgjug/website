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
	public void testCreateArticle() {

		Article newArticle = new Article();
		response = articleService.createArticle(newArticle);

		verify(articleRepositoryMock).save(newArticle);
		assertEquals(response.getStatus(),
				Response.Status.CREATED.getStatusCode());

		response = articleService.createArticle(article);

		verify(articleRepositoryMock, atLeastOnce()).save(article);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}

	@Test
	public void testUpdateArticle() {

		article.setTitle("TITLE");
		Article updatedArticle = new Article();
		updatedArticle.setId(1L);
		updatedArticle.setTitle("title");
		when(articleRepositoryMock.save(article)).thenReturn(updatedArticle);
		
		response = articleService.updateArticle(article);
		
		verify(articleRepositoryMock).save(article);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
		Article result = (Article) response.getEntity();
		assertEquals(result.getTitle(), "title");
		assertTrue(result.getId() == 1L);
		
		Article newArticle = new Article();
		newArticle.setId(3L);
		
		response = articleService.updateArticle(newArticle);
		assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
	}

	@Test
	public void testDeleteArticle() {

		response = articleService.deleteArticle("2");

		assertEquals(response.getStatus(),
				Response.Status.NO_CONTENT.getStatusCode());
		verify(articleRepositoryMock, never()).remove(article);

		response = articleService.deleteArticle("1");

		assertEquals(response.getStatus(),
				Response.Status.NO_CONTENT.getStatusCode());
		verify(articleRepositoryMock).remove(article);
	}

	@Test
	public void testFindArticle() {

		response = articleService.findArticle("2");

		assertEquals(response.getStatus(),
				Response.Status.NOT_FOUND.getStatusCode());

		response = articleService.findArticle("1");

		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
	}

	@Test
	public void testAllPages() {

		response = articleService.allArticles();
		ArrayList<?> allArticles = (ArrayList<?>) response.getEntity();

		assertEquals(allArticles.size(), 0);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

		Article secondArticle = new Article();
		secondArticle.setId(2L);
		secondArticle.setCreatedDate(new Date());
		when(articleRepositoryMock.findAll()).thenReturn(
				Arrays.asList(article, secondArticle));
		response = articleService.allArticles();
		allArticles = (ArrayList<?>) response.getEntity();

		assertEquals(allArticles.size(), 2);
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

		ArticleInfo firstArticleInfo = (ArticleInfo) allArticles.get(0);
		ArticleInfo secondArticleInfo = (ArticleInfo) allArticles.get(1);

		assertEquals(firstArticleInfo.getId().longValue(), 2L);
		assertEquals(secondArticleInfo.getId().longValue(), 1L);
	}

}
