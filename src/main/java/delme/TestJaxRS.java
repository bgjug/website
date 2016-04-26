package delme;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import bg.jug.website.model.cms.Page;
import bg.jug.website.repository.cms.PageRepository;

@Path("test")
@Stateless
public class TestJaxRS {

	@Inject
	private PageRepository pageRepository;
	
	@GET
	public List<Page> testMe(){
		Page newPageBaby = new Page();
		
		newPageBaby.setContent("xaa");
		newPageBaby.setPublished(true);
		newPageBaby.setTitle("TestMe");
		
		pageRepository.save(newPageBaby);
		return pageRepository.findAll();
	}
		
}
