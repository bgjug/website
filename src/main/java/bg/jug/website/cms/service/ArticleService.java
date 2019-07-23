package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.repository.ArticleRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static bg.jug.website.core.util.PagingUtils.findPageStartingElement;

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
	@Transactional
	@RolesAllowed("admin")
	public Response createArticle(Article article) {
		return saveArticleInternal(article);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@RolesAllowed("admin")
	public Response updateArticle(Article article) {
	    return saveArticleInternal(article);
	}

	@DELETE
	@Path("/{id}")
    @Transactional
	@RolesAllowed("admin")
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
		Article article = articleRepository.findById(Long.parseLong(id));
		if (article == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.status(Response.Status.OK).entity(article).build();
	}

	@GET
	public Response allArticles(@DefaultValue("1") @QueryParam("page") int page,
								@DefaultValue("10") @QueryParam("size") int size) {
		List<Article> allArticles = articleRepository.findAll(findPageStartingElement(page, size), size);
		return Response.ok(allArticles).build();
	}

	@GET
	@Path("/tag/{name}")
	public Response allArticles(@PathParam("name") String tagName,
								@DefaultValue("1") @QueryParam("page") int page,
								@DefaultValue("10") @QueryParam("size") int size) {
		List<Article> allArticles = articleRepository.findAllByTag(tagName, findPageStartingElement(page, size), size);
		return Response.ok(allArticles).build();
	}

	@Transactional
	private Response saveArticleInternal(Article article) {
		boolean isArticleExist = article.getId() != null && articleRepository.findBy(article.getId()) != null;
		Response.Status status = isArticleExist ? Response.Status.OK
				: Response.Status.CREATED;
		Article createdArticle = articleRepository.save(article);
		return Response.status(status).entity(createdArticle).build();
	}


}
