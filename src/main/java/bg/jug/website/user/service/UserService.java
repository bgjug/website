package bg.jug.website.user.service;

import bg.jug.website.core.util.CryptUtils;
import bg.jug.website.core.util.JwtUtils;
import bg.jug.website.user.model.User;
import bg.jug.website.user.service.dto.LoginDetails;
import bg.jug.website.user.service.dto.RoleUpdate;
import org.apache.commons.lang.RandomStringUtils;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

    private static final int JWT_EXPIRE_SECONDS = 3600;

    @Inject JwtUtils jwtUtils;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response registerUser(@Valid LoginDetails registrationDetails) {
        // TODO Check if email is already registered
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String encrypted = CryptUtils.encryptPassword(registrationDetails.getPassword() + salt);
        User newUser = new User(registrationDetails.getEmail(), encrypted, salt);
        newUser.persist();

        return Response.ok().header("Authorization", getJwt(newUser)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response loginUser(LoginDetails loginDetails) {
        User user = User.find("email", loginDetails.getEmail()).firstResult();

        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        String encrypted = CryptUtils.encryptPassword(loginDetails.getPassword() + user.getSalt());
        if (!user.getPassword().equals(encrypted)) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok().header("Authorization", getJwt(user)).build();
    }

    @POST
    @Path("/role")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    @Transactional
    public Response addRoles(RoleUpdate newRoles) {
        User user = User.find("email", newRoles.getEmail()).firstResult();
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        user.getRoles().addAll(newRoles.getRoleUpdates());
        return Response.ok().build();
    }


    private String getJwt(User newUser) {
        String jwt = jwtUtils.generateJWT(newUser.getEmail(), newUser.getRoles(), JWT_EXPIRE_SECONDS);
        return "Bearer " + jwt;
    }

}
