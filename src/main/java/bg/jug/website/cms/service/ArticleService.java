package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Article;
import bg.jug.website.core.util.EntityUtils;
import bg.jug.website.taxonomy.model.Tag;
import io.quarkus.panache.common.Page;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestScoped
@Path("/article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response createArticle(@Valid Article article) {
        replaceTagsWithExistingOnes(article);
        article.persist();
        return Response.status(Response.Status.CREATED).entity(article).build();
    }

    private void replaceTagsWithExistingOnes(@Valid Article article) {
        if (article.getTags() != null && !article.getTags().isEmpty()) {
            Set<Tag> tagsToPersist = new HashSet<>();
            article.getTags().stream()
                   .forEach(possiblyNewTag ->
                            {
                                List<Tag> existingTags = Tag.find(Tag.FIND_BY_NAME, possiblyNewTag.getName()).page(
                                                Page.of(0, 1)).list();
                                if(existingTags != null && !existingTags.isEmpty()) {
                                    Tag existingTag = existingTags.get(0);
                                    tagsToPersist.add(existingTag);
                                } else {
                                    tagsToPersist.add(possiblyNewTag);
                                }
                            });
            article.setTags(tagsToPersist);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response updateArticle(@Valid Article article) {
        if(article.getId() == null || article.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Article persisted = Article.findById(article.getId());

        if(persisted == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        } else {
            EntityUtils.updateEntity(persisted, article);
            replaceTagsWithExistingOnes(article);
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
