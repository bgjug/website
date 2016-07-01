package bg.jug.website.cms.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.model.Page;

@Repository
public interface ArticleRepository extends EntityRepository<Article, Long>
{
}
