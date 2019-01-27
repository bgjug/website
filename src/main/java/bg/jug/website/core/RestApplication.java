package bg.jug.website.core;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Ivan St. Ivanov
 */
@ApplicationPath("/api")
@LoginConfig(authMethod = "MP-JWT")
public class RestApplication extends Application {
}
