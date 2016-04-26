package bg.jug.website.cms;

import bg.jug.website.model.cms.Page;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Ivan St. Ivanov
 */
@Stateless
@Path("/page")
public class PageService {

    @Inject
    private PageRepository pageRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPage(Page newPage) {
        Page createdPage = pageRepository.save(newPage);
        return Response.status(Response.Status.CREATED).entity(createdPage).build();
    }
}
