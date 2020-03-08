package bg.jug.website.sponsors.service;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.Map;

import bg.jug.website.sponsors.model.Sponsor;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@RequestScoped
@Path("/sponsor")
@Produces(MediaType.APPLICATION_JSON)
public class SponsorService {

    @POST
    @RolesAllowed("admin")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response createSponsor(MultipartFormDataInput input) {
        Sponsor sponsor = new Sponsor();

        try {
            updateSponsorFieldsFromInputData(input, sponsor);
        } catch (IOException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
        sponsor.persistAndFlush();

        return Response.ok().build();
    }

    private void updateSponsorFieldsFromInputData(MultipartFormDataInput input, Sponsor sponsor)
        throws IOException {
        Map<String, List<InputPart>> paramsMap = input.getFormDataMap();
        String name = paramsMap.get("sponsor").get(0).getBodyAsString();
        String url = paramsMap.get("web_url").get(0).getBodyAsString();
        sponsor.setName(name);
        sponsor.setUrl(url);

        if (paramsMap.containsKey("image_type")) {
            fillSponsorImageFields(sponsor, paramsMap);
        }
    }

    private void fillSponsorImageFields(Sponsor sponsor, Map<String, List<InputPart>> paramsMap)
        throws IOException {

        String type = paramsMap.get("image_type").get(0).getBodyAsString();
        InputStream logoStream = paramsMap.get("logo").get(0).getBody(InputStream.class, null);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];

            int length = logoStream.read(buffer);
            while (length > 0) {
                baos.write(buffer, 0, length);
                length = logoStream.read(buffer);
            }
            sponsor.setType(type);
            sponsor.setLogo(baos.toByteArray());
        }
    }

    @PUT
    @RolesAllowed("admin")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response updateSponsor(MultipartFormDataInput input) {
        Map<String, List<InputPart>> paramsMap = input.getFormDataMap();

        if (!paramsMap.containsKey("id")) {
            return Response.status(BAD_REQUEST).entity("missing ID").build();
        }

        try {
            long id = paramsMap.get("id").get(0).getBody(Long.class, null);
            Sponsor sponsor = Sponsor.findById(id);
            if (sponsor == null) {
                return Response.status(NOT_FOUND).build();
            }

            updateSponsorFieldsFromInputData(input, sponsor);
        } catch (IOException e) {
            Response.serverError().entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @GET
    public Response allSponsors() {
        List<Sponsor> allSubmissions = Sponsor.findAll().list();
        return Response.ok(allSubmissions).build();
    }

    @GET
    @Path("{id}")
    public Response sponsor(@PathParam("id") long id) {
        Sponsor sponsor = Sponsor.findById(id);
        return Response.ok().entity(sponsor).build();
    }

    @GET
    @Path("/logo/{id}")
    public Response sponsorLogo(@PathParam("id") long id) {
        Sponsor sponsor = Sponsor.findById(id);
        return Response.ok().type(sponsor.getType()).entity(sponsor.getLogo()).build();
    }
}
