package bg.jug.website.cms.repository;

import bg.jug.website.cms.model.Article;
import org.apache.deltaspike.data.api.*;

import java.util.List;

@Repository
public interface ArticleRepository extends EntityRepository<Article, Long> {

    @Query(named = Article.FIND_ALL)
    List<Article> findAll(@FirstResult int start, @MaxResults int pageSize);

    @Query(named = Article.FIND_BY_ID, singleResult = SingleResultType.OPTIONAL)
    Article findById(Long id);

}
