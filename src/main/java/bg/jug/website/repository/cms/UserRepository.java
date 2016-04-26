package bg.jug.website.repository.cms;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import bg.jug.website.model.cms.Page;
import bg.jug.website.model.user.User;

@Repository
public interface UserRepository extends EntityRepository<User, Long>
{
}
