package bg.jug.website.cfp.service;

import bg.jug.website.cfp.model.Submission;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.panache.common.Page;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/submission")
@Produces(MediaType.APPLICATION_JSON)
public class SubmissionService {

    @Inject
    Mailer mailer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createArticle(@Valid Submission submission) {
        submission.persist();

        String emailBody = "From:" + submission.getName() + "<" + submission.getEmail() + ">\n"
                        + "Topic:" + submission.getTitle() + "\n"
                        + "Talk details:" + submission.getDetails() + "\n";
        mailer.send(Mail.withText("bg-jug-board@googlegroups.com", "jug.bg cfp form submission:" + submission.getTitle(),
                                  emailBody));

        return Response.status(Response.Status.CREATED).entity(submission).build();
    }

    @GET
    @RolesAllowed("admin")
    public Response alLSubmissions(@DefaultValue("1") @QueryParam("page") int page,
                                @DefaultValue("10") @QueryParam("size") int size) {
        List<Submission> allSubmissions = Submission.findAll()
                                           .page(Page.of(page - 1, size)).list();

        return Response.ok(allSubmissions).build();
    }
}
