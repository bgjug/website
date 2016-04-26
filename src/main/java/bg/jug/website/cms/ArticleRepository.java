package bg.jug.website.cms;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import bg.jug.website.model.cms.Article;
import bg.jug.website.model.cms.Page;

@Repository
public interface ArticleRepository extends EntityRepository<Article, Long>
{
}
