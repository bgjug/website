package bg.jug.website.cms.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Repository;

import bg.jug.website.cms.model.Page;

import java.util.List;

@Repository
public interface PageRepository extends EntityRepository<Page, Long> {

    List<Page> findAll(@FirstResult int start, @MaxResults int pageSize);
	
}
