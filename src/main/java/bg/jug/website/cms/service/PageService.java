package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Page;
import bg.jug.website.cms.repository.PageRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan St. Ivanov
 */
@Stateless
@Path("/page")
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
	public Response createPage(Page newPage) {

		return savePageInternal(newPage);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePage(Page page) {
		
		return savePageInternal(page);
	}

	@DELETE
	@Path("/{id}")
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
	public Response allPages() {

		List<Page> allPages = pageRepository.findAll();
		List<PageInfo> infoPages = allPages.stream()
				.map(page -> new PageInfo(page.getId(), page.getTitle()))
				.collect(Collectors.toList());
		return Response.ok(new GenericEntity<List<PageInfo>>(infoPages) {}).build();
	}

	private Response savePageInternal(Page page) {

		boolean isPageExist = page.getId() != null && pageRepository.findBy(page.getId()) != null;
		Response.Status status = isPageExist ? Response.Status.OK
				: Response.Status.CREATED;
		Page createdPage = pageRepository.save(page);
		return Response.status(status).entity(createdPage).build();
	}

    @XmlRootElement
	private static class PageInfo {
		private Long id;
		private String title;

        public PageInfo() {
        }

        PageInfo(Long id, String title) {
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
