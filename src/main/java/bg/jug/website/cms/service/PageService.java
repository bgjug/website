package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.model.Page;
import bg.jug.website.cms.repository.PageRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
@RequestScoped
@Path("/page")
@Produces(MediaType.APPLICATION_JSON)
public class PageService {

    private static final int CONTENT_PREVIEW_LENGTH = 20;

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
    @Transactional
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
                .filter(page -> !(page instanceof Article))
				.map(page -> new PageInfo(page.getId(), page.getTitle(), stripContent(page.getContent())))
				.collect(Collectors.toList());
		return Response.ok(new GenericEntity<List<PageInfo>>(infoPages){}).build();
	}

    private String stripContent(String content) {
	    if (content.length() > CONTENT_PREVIEW_LENGTH) {
            return content.substring(0, CONTENT_PREVIEW_LENGTH);
        }
	    else {
            return content;
        }
    }

    @Transactional
	private Response savePageInternal(Page page) {
		boolean isPageExist = page.getId() != null && pageRepository.findBy(page.getId()) != null;
		Response.Status status = isPageExist ? Response.Status.OK
				: Response.Status.CREATED;
		Page createdPage = pageRepository.save(page);
		return Response.status(status).entity(createdPage).build();
	}

    @XmlRootElement
	public static class PageInfo {
		private Long id;
		private String title;
		private String shortContent;

        public PageInfo() {
        }

        public PageInfo(Long id, String title, String shortContent) {
            this.id = id;
            this.title = title;
            this.shortContent = shortContent;
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

        public String getShortContent() {
            return shortContent;
        }

        public void setShortContent(String shortContent) {
            this.shortContent = shortContent;
        }
    }

}
