package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Page;
import bg.jug.website.cms.repository.PageRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static bg.jug.website.core.util.PagingUtils.findPageStartingElement;

/**
 * @author Ivan St. Ivanov
 */
@RequestScoped
@Path("/page")
@Produces(MediaType.APPLICATION_JSON)
public class PageService {

    @Inject
	private PageRepository pageRepository;

    public PageService() {
    }

	public PageService(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@RolesAllowed("admin")
	public Response createPage(Page newPage) {
		return savePageInternal(newPage);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@RolesAllowed("admin")
	public Response updatePage(Page page) {
		return savePageInternal(page);
	}

	@DELETE
	@Path("/{id}")
    @Transactional
	@RolesAllowed("admin")
	public Response deletePage(@PathParam("id") String id) {
		Page page = pageRepository.findBy(Long.parseLong(id));
		if (page != null) {
			pageRepository.remove(page);
		}

		return Response.status(Response.Status.NO_CONTENT).build();
	}

	@GET
	@Path("/{id}")
	public Response findPage(@PathParam("id") String id) {
		Page page = pageRepository.findBy(Long.parseLong(id));
		if (page == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.status(Response.Status.OK).entity(page).build();
	}

	@GET
	public Response allPages(@DefaultValue("1") @QueryParam("page") int page,
							 @DefaultValue("10") @QueryParam("size") int size) {
		List<Page> allPages = pageRepository.findAll(findPageStartingElement(page, size), size);
		return Response.ok(allPages).build();
	}

    @Transactional
	private Response savePageInternal(Page page) {
		boolean isPageExist = page.getId() != null && pageRepository.findBy(page.getId()) != null;
		Response.Status status = isPageExist ? Response.Status.OK
				: Response.Status.CREATED;
		Page createdPage = pageRepository.save(page);
		return Response.status(status).entity(createdPage).build();
	}

}
