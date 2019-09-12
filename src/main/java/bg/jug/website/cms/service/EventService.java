package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Event;
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
@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
public class EventService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response createEvent(@Valid Event newEvent) {
        newEvent.persist();
        return Response.status(Response.Status.CREATED).entity(newEvent).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Response updateEvent(@Valid Event event) {

        if(event.getId() == null || event.getId() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Event persisted = Event.findById(event.getId());

        if (persisted == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            EntityUtils.updateEntity(persisted, event);

            //Eager fetching. Otherwise page will not serialize
            persisted.getTags().size();
            return Response.ok(persisted).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    public Response deleteEvent(@PathParam("id") String id) {
        Event event = Event.findById(Long.parseLong(id));
        if (event != null) {
            event.delete();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findEvent(@PathParam("id") String id) {
        Event event = Event.findById(Long.parseLong(id));
        if (event == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(event).build();
    }

    @GET
    public Response allEvents(@DefaultValue("1") @QueryParam("page") int page,
                             @DefaultValue("10") @QueryParam("size") int size) {
        List<Event> allEvents = Event.findAll().page(io.quarkus.panache.common.Page.of(page - 1, size)).list();
        return Response.ok(allEvents).build();
    }

}
