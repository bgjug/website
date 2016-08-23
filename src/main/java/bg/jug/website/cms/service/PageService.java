package bg.jug.website.cms.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import bg.jug.website.cms.model.Page;
import bg.jug.website.cms.repository.PageRepository;

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

		return Response.status(Response.Status.OK).entity(infoPages).build();
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

		public PageInfo(Long id, String title) {
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
