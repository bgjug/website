package bg.jug.website.taxonomy.service;

import bg.jug.website.taxonomy.model.Tag;
import bg.jug.website.taxonomy.repository.TagRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
import java.util.List;

import static bg.jug.website.core.util.PagingUtils.findPageStartingElement;

/**
 * @author Ivan St. Ivanov
 */
@RequestScoped
@Path("/tag")
@Produces(MediaType.APPLICATION_JSON)
public class TagService {

    @Inject
	private TagRepository tagRepository;

    public TagService() {
    }

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@RolesAllowed("admin")
	public Response create(Tag tag) {
		return saveInternal(tag);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@RolesAllowed("admin")
	public Response update(Tag tag) {
		return saveInternal(tag);
	}

	@DELETE
	@Path("/{id}")
    @Transactional
	@RolesAllowed("admin")
	public Response delete(@PathParam("id") String id) {
		Tag tag = tagRepository.findBy(Long.parseLong(id));
		if (tag != null) {
			tagRepository.remove(tag);
		}

		return Response.status(Response.Status.NO_CONTENT).build();
	}

	@GET
	@Path("/{id}")
	public Response find(@PathParam("id") String id) {
		Tag tag = tagRepository.findBy(Long.parseLong(id));
		if (tag == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.status(Response.Status.OK).entity(tag).build();
	}

	@GET
	public Response all(@DefaultValue("1") @QueryParam("page") int page,
							 @DefaultValue("10") @QueryParam("size") int size) {
		List<Tag> allTags = tagRepository.findAll(findPageStartingElement(page, size), size);
		return Response.ok(allTags).build();
	}

    @Transactional
	private Response saveInternal(Tag tag) {
		boolean isTagExist = tag.getId() != null && tagRepository.findBy(tag.getId()) != null;
		Response.Status status = isTagExist ? Response.Status.OK
				: Response.Status.CREATED;
		Tag createdTag = tagRepository.save(tag);
		return Response.status(status).entity(createdTag).build();
	}

}
