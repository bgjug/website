package bg.jug.website.user.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import bg.jug.website.cms.model.Page;
import bg.jug.website.user.model.User;

@Repository
public interface UserRepository extends EntityRepository<User, Long> {
}
