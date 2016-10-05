package bg.jug.website.cms.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.repository.ArticleRepository;

@RequestScoped
@Path("/article")
@Produces(MediaType.APPLICATION_JSON)
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateArticle(Article article) {
	    return saveArticleInternal(article);
	}

	@DELETE
	@Path("/{id}")
    @Transactional
	public Response deleteArticle(@PathParam("id") String id) {
		Article article = articleRepository.findBy(Long.parseLong(id));
		if (article != null) {
			articleRepository.remove(article);
		}

		return Response.status(Response.Status.NO_CONTENT).build();
	}

	@GET
	@Path("/{id}")
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

		return Response.ok(new GenericEntity<List<ArticleInfo>>(articleInfo){}).build();
	}

	@Transactional
	private Response saveArticleInternal(Article article) {
		boolean isArticleExist = article.getId() != null && articleRepository.findBy(article.getId()) != null;
		Response.Status status = isArticleExist ? Response.Status.OK
				: Response.Status.CREATED;
		Article createdArticle = articleRepository.save(article);
		return Response.status(status).entity(createdArticle).build();
	}

	@XmlRootElement
	public static class ArticleInfo {

		private Long id;
		private String title;

        public ArticleInfo() {
        }

        ArticleInfo(Long id, String title) {
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
