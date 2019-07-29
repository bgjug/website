package bg.jug.website.taxonomy.service;

import bg.jug.website.core.util.EntityUtils;
import bg.jug.website.taxonomy.model.Tag;
import io.quarkus.panache.common.Page;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Ivan St. Ivanov
 */
@RequestScoped
@Path("/tag")
@Produces(MediaType.APPLICATION_JSON)
public class TagService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response create(@Valid Tag tag) {
        tag.persist();
        return Response.status(Response.Status.CREATED).entity(tag).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response update(Tag tag) {
        if(tag.getId() == null || tag.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Tag persisted = Tag.findById(tag.getId());

        if (persisted == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            EntityUtils.updateEntity(persisted, tag);

            return Response.ok(persisted).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    public Response delete(@PathParam("id") String id) {
        Tag tag = Tag.findById(Long.parseLong(id));
        if (tag != null) {
            tag.delete();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") String id) {
        Tag tag = Tag.findById(Long.parseLong(id));
        if (tag == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(tag).build();
    }

    @GET
    public Response all(@DefaultValue("1") @QueryParam("page") int page,
                        @DefaultValue("10") @QueryParam("size") int size) {
        List<Tag> allTags = Tag.findAll().page(Page.of(page - 1, size)).list();
        return Response.ok(allTags).build();
    }
}
