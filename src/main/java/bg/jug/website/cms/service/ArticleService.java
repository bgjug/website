package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Article;
import bg.jug.website.core.util.EntityUtils;
import io.quarkus.panache.common.Page;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response createArticle(@Valid Article article) {
        article.persist();
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response updateArticle(@Valid Article article) {
        Article persisted = Article.findById(article.getId());

        if(persisted == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            EntityUtils.updateEntity(persisted, article);
            //Eager fetching. Otherwise article will not serialize
            persisted.getTags().size();
            return Response.ok(persisted).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    public Response deleteArticle(@PathParam("id") String id) {

        Article article = Article.findById(Long.parseLong(id));

        if (article != null) {
            article.delete();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findArticle(@PathParam("id") String id) {
        Article article = Article.findById(Long.parseLong(id));
        if (article == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(article).build();
    }

    @GET
    public Response allArticles(@DefaultValue("1") @QueryParam("page") int page,
                                @DefaultValue("10") @QueryParam("size") int size) {
        List<Article> allArticles = Article.find(Article.FIND_ALL)
                .page(Page.of(page - 1, size)).list();

        return Response.ok(allArticles).build();
    }

    @GET
    @Path("/tag/{name}")
    public Response allArticles(@PathParam("name") String tagName,
                                @DefaultValue("1") @QueryParam("page") int page,
                                @DefaultValue("10") @QueryParam("size") int size) {
        List<Article> allArticles = Article
                .find(Article.FIND_ALL_BY_TAG, tagName)
                .page(Page.of(page - 1, size))
                .list();

        return Response.ok(allArticles).build();
    }
}
