package bg.jug.website.cms.service;

import bg.jug.website.cms.model.Article;
import bg.jug.website.taxonomy.model.Tag;
import io.quarkus.panache.common.Page;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Base class for services dealing with tag relations
 */
public class TagAwareService {
    protected void replaceTagsWithExistingOnes(Article article) {
        if (article.getTags() != null && !article.getTags().isEmpty()) {
            Set<Tag> tagsToPersist = new HashSet<>();
            article.getTags()
                   .forEach(possiblyNewTag ->
                            {
                                List<Tag> existingTags = Tag.find(Tag.FIND_BY_NAME, possiblyNewTag.getName()).page(
                                                Page.of(0, 1)).list();
                                if(existingTags != null && !existingTags.isEmpty()) {
                                    Tag existingTag = existingTags.get(0);
                                    tagsToPersist.add(existingTag);
                                } else {
                                    tagsToPersist.add(possiblyNewTag);
                                }
                            });
            article.setTags(tagsToPersist);
        }
    }
}
