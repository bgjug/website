package bg.jug.website.taxonomy.repository;

import bg.jug.website.taxonomy.model.Tag;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface TagRepository extends EntityRepository<Tag, Long> {
}
