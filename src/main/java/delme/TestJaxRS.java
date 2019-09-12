package delme;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.model.Event;
import bg.jug.website.core.util.CryptUtils;
import bg.jug.website.taxonomy.model.Tag;
import bg.jug.website.user.model.User;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Path("test")
@RequestScoped
public class TestJaxRS {

    @GET
    @Produces("application/json")
    @Transactional
    public List<Article> testMe() {
        Article home = new Article();
        home.setContent("Home Baby");
        home.setPublished(true);
        home.setTitle("Home");
        home.persist();

        Tag homeTag = new Tag();
        homeTag.setName("home");
        homeTag.persist();

        home.setTags(Collections.singleton(homeTag));
        home.persist();

        Article about = new Article();
        about.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        about.setPublished(true);
        about.setTitle("About");
        about.persist();

        Tag aboutTag = new Tag();
        aboutTag.setName("about");
        aboutTag.persist();

        about.setTags(Collections.singleton(aboutTag));
        about.persist();

        Event event1 = new Event();
        event1.setContent("Thsi is some event info <br/> this is new line");
        event1.setPublished(true);
        event1.setEventDate(LocalDateTime.now());
        event1.setLocation("Sofia, Bulgaria");
        event1.setTitle("Amazing Event");
        event1.persist();

        Tag eventsTag = new Tag();
        eventsTag.setName("events");
        eventsTag.persist();

        event1.setTags(Collections.singleton(eventsTag));
        event1.persist();

        Article news1 = new Article();
        news1.setContent("Good news Everyone <br/> this is new line");
        news1.setPublished(true);
        news1.setTitle("Amazing news");
        news1.persist();

        Article news2 = new Article();
        news2.setContent("fcking NAVIGATION Everyone <br/> this is new line");
        news2.setPublished(true);
        news2.setTitle("Amazing news 2");
        news2.persist();

        Tag newsTag = new Tag();
        newsTag.setName("news");
        newsTag.persist();

        news1.setTags(Collections.singleton(newsTag));
        news1.persist();

        news2.setTags(Collections.singleton(newsTag));
        news2.persist();

        Tag cfpTag = new Tag();
        cfpTag.setName("submit a talk");
        cfpTag.persist();

        Tag contactsTag = new Tag();
        contactsTag.setName("contacts");
        contactsTag.persist();

        Tag loginTag = new Tag();
        loginTag.setName("login");
        loginTag.persist();

        User nayden = new User();
        nayden.setFullname("Nayden Gochev");
        nayden.setEmail("nayden@example.org");
        nayden.setPassword(CryptUtils.encryptPassword("supersecret"));
        nayden.setSalt("");
        nayden.persist();

        Article personalArticle = new Article();
        personalArticle.setContent("Hello peoples");
        personalArticle.setPublished(true);
        personalArticle.setTitle("Some amazing ArticleDTO");
        personalArticle.setAuthor(nayden);
        personalArticle.persist();

        User admin = new User();
        admin.setFullname("Dmitry Alexandrov");
        admin.setEmail("mitya@example.org");
        admin.setPassword(CryptUtils.encryptPassword("supersecret"));
        admin.setSalt("");
        admin.setRoles(Collections.singletonList("admin"));
        admin.persist();

        return Article.listAll();
    }

}
