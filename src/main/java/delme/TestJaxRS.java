package delme;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.model.Page;
import bg.jug.website.cms.repository.ArticleRepository;
import bg.jug.website.cms.repository.PageRepository;
import bg.jug.website.user.model.User;
import bg.jug.website.user.repository.UserRepository;

@Path("test")
@RequestScoped
public class TestJaxRS {

	@Inject
	private PageRepository pageRepository;
	@Inject
	private ArticleRepository articleRepository;
    @Inject
    private UserRepository userRepository;

	@GET
    @Produces("application/json")
    @Transactional
	public List<Page> testMe() {
        Page about = new Page();
        about.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        about.setPublished(true);
        about.setTitle("About");
        pageRepository.save(about);

        Page home = new Page();
        home.setContent("Hello peoples");
        home.setPublished(true);
        home.setTitle("Home");
        pageRepository.save(home);

        User nayden = new User();
        nayden.setFullname("Nayden Gochev");
        nayden.setEmail("nayden@example.org");
        nayden.setPassword("supersecret");
        userRepository.save(nayden);

        Article myFirst = new Article();
        myFirst.setContent("Hello peoples");
        myFirst.setPublished(true);
        myFirst.setTitle("Home");
        myFirst.setCreatedDate(new Date());
        myFirst.setAuthor(nayden);
        articleRepository.save(myFirst);

        return pageRepository.findAll();
    }
		
}
