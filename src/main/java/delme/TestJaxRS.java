package delme;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.repository.ArticleRepository;
import bg.jug.website.core.util.CryptUtils;
import bg.jug.website.taxonomy.model.Tag;
import bg.jug.website.taxonomy.repository.TagRepository;
import bg.jug.website.user.model.User;
import bg.jug.website.user.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Path("test")
@RequestScoped
public class TestJaxRS {

//	@Inject
//	private PageRepository pageRepository;
	@Inject
	private ArticleRepository articleRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private TagRepository tagRepository;

	@GET
    @Produces("application/json")
    @Transactional
	public List<Article> testMe() {
        Article home = new Article();
        home.setContent("Home Baby");
        home.setPublished(true);
        home.setTitle("Home");
        articleRepository.save(home);

        Tag homeTag = new Tag();
        homeTag.setName("home");
//        homeTag.setArticles(Collections.singleton(home));
        tagRepository.save(homeTag);

        home.setTags(Collections.singleton(homeTag));
        articleRepository.save(home);

        Article about = new Article();
        about.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        about.setPublished(true);
        about.setTitle("About");
        articleRepository.save(about);

        Tag aboutTag = new Tag();
        aboutTag.setName("about");
//        aboutTag.setArticles(Collections.singleton(about));
        tagRepository.save(aboutTag);

        about.setTags(Collections.singleton(aboutTag));
        articleRepository.save(about);

        Tag eventsTag = new Tag();
        eventsTag.setName("events");
        tagRepository.save(eventsTag);

        Tag newsTag = new Tag();
        newsTag.setName("news");
        tagRepository.save(newsTag);

        Tag cfpTag = new Tag();
        cfpTag.setName("submit a talk");
        tagRepository.save(cfpTag);

        Tag contactsTag = new Tag();
        contactsTag.setName("contacts");
        tagRepository.save(contactsTag);

        User nayden = new User();
        nayden.setFullname("Nayden Gochev");
        nayden.setEmail("nayden@example.org");
        nayden.setPassword(CryptUtils.encryptPassword("supersecret"));
        nayden.setSalt("");
        userRepository.save(nayden);

        Article personalArticle = new Article();
        personalArticle.setContent("Hello peoples");
        personalArticle.setPublished(true);
        personalArticle.setTitle("Some amazing Article");
        personalArticle.setCreatedDate(new Date());
        personalArticle.setAuthor(nayden);
        articleRepository.save(personalArticle);

        User admin = new User();
        admin.setFullname("Dmitry Alexandrov");
        admin.setEmail("mitya@example.org");
        admin.setPassword(CryptUtils.encryptPassword("supersecret"));
        admin.setSalt("");
        admin.setRoles(Collections.singletonList("admin"));
        userRepository.save(admin);

        return articleRepository.findAll();
    }
		
}
