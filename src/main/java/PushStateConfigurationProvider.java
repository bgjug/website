import org.ocpsoft.logging.Logger;
import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.config.Log;
import org.ocpsoft.rewrite.servlet.config.*;

import javax.servlet.ServletContext;

/**
 * html5 push state
 *
 * @author Mihail
 */
@RewriteConfiguration
public class PushStateConfigurationProvider extends HttpConfigurationProvider {
    @Override
    public Configuration getConfiguration(final ServletContext context) {
        return ConfigurationBuilder.begin()
            .addRule()
            .when(Direction.isInbound()
                .and(Path.matches("/page/{path}")))
//                .andNot(Resource.exists("/{path}")))
//                .andNot(Path.matches("/api/{param}")))
            .perform((Log.message(Logger.Level.INFO, "Forwarding to index.html from /page/{path}").and(Forward.to("/index.html"))))
            .where("path").matches(".*");
    }

    @Override
    public int priority() {
        /* This provides ordering if you have multiple configurations */
        return 10;
    }
}