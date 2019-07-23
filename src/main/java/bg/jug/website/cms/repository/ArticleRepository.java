package bg.jug.website.cms.repository;

import bg.jug.website.cms.model.Article;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.FirstResult;
import org.apache.deltaspike.data.api.MaxResults;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.List;

@Repository
public interface ArticleRepository extends EntityRepository<Article, Long> {

    @Query(named = Article.FIND_ALL)
    List<Article> findAll(@FirstResult int start, @MaxResults int pageSize);

    @Query(named = Article.FIND_BY_ID, singleResult = SingleResultType.OPTIONAL)
    Article findById(Long id);

    @Query(named = Article.FIND_ALL_BY_TAG)
    List<Article> findAllByTag(String name, @FirstResult int start, @MaxResults int pageSize);

}
