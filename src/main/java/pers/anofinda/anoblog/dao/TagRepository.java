package pers.anofinda.anoblog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import pers.anofinda.anoblog.entity.Tag;

import java.util.Optional;

/**
 * @author dongyudeng
 */
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    boolean existsByTagName(String tagName);

    Optional<Tag> findByTagName(String tagName);
}
