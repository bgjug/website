package bg.jug.website.cms;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import bg.jug.website.model.cms.Article;

@Stateless
@Path("/articles")
public class ArticleService {

	@Inject
	private ArticleRepository articleRepository;

	public ArticleService() {

	}

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createArticle(Article article) {

		return saveArticleInternal(article);
	}

	@PUT
	@PathParam("id")
	public Response updateArticle(@PathParam("id") String id) {

		Article article = articleRepository.findBy(Long.parseLong(id));
		if (article == null) {
			return saveArticleInternal(new Article());
		}

		return saveArticleInternal(article);
	}

	@DELETE
	@PathParam("id")
	public Response deleteArticle(@PathParam("id") String id) {

		Article article = articleRepository.findBy(Long.parseLong(id));
		if (article != null) {
			articleRepository.remove(article);
		}

		return Response.status(Response.Status.NO_CONTENT).build();
	}

	@GET
	@PathParam("id")
	public Response findArticle(@PathParam("id") String id) {

		Article article = articleRepository.findBy(Long.parseLong(id));
		if (article == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.status(Response.Status.OK).entity(article).build();
	}

	@GET
	public Response allArticles() {

		List<Article> allArticles = articleRepository.findAll();
		allArticles.sort((article1, article2) -> article2.getCreatedDate()
				.compareTo(article1.getCreatedDate()));

		List<ArticleInfo> articleInfo = allArticles
				.stream()
				.map(article -> new ArticleInfo(article.getId(), article
						.getTitle())).collect(Collectors.toList());

		return Response.status(Response.Status.OK).entity(articleInfo).build();
	}

	private Response saveArticleInternal(Article article) {

		Response.Status status = article.getId() == null ? Response.Status.CREATED
				: Response.Status.OK;
		Article createdArticle = articleRepository.save(article);
		return Response.status(status).entity(createdArticle).build();
	}

	@XmlRootElement
	static class ArticleInfo {

		private Long id;
		private String title;

		public ArticleInfo(Long id, String title) {
			super();
			this.id = id;
			this.title = title;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}

}
