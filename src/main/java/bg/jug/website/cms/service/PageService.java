package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Page;
import bg.jug.website.core.util.EntityUtils;

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
@Path("/page")
@Produces(MediaType.APPLICATION_JSON)
public class PageService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response createPage(@Valid Page newPage) {
        newPage.persist();
        return Response.status(Response.Status.CREATED).entity(newPage).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response updatePage(@Valid Page page) {

        if(page.getId() == null || page.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Page persisted = Page.findById(page.getId());

        if (persisted == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            EntityUtils.updateEntity(persisted, page);

            //Eager fetching. Otherwise page will not serialize
            persisted.getTags().size();
            return Response.ok(persisted).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    public Response deletePage(@PathParam("id") String id) {
        Page page = Page.findById(Long.parseLong(id));
        if (page != null) {
            page.delete();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findPage(@PathParam("id") String id) {
        Page page = Page.findById(Long.parseLong(id));
        if (page == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(page).build();
    }

    @GET
    public Response allPages(@DefaultValue("1") @QueryParam("page") int page,
                             @DefaultValue("10") @QueryParam("size") int size) {
        List<Page> allPages = Page.findAll().page(io.quarkus.panache.common.Page.of(page - 1, size)).list();
        return Response.ok(allPages).build();
    }

}
