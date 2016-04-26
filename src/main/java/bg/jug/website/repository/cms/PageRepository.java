package bg.jug.website.repository.cms;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import bg.jug.website.model.cms.Page;

@Repository
public interface PageRepository extends EntityRepository<Page, Long>
{
	
}
