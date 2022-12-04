package pers.anofinda.anoblog.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import pers.anofinda.anoblog.entity.Essay;

import java.util.Optional;
import java.util.List;

/**
 * @author dongyudeng
 */
public interface EssayRepository extends PagingAndSortingRepository<Essay, Long> {

    Optional<Essay> findByTittle(String title);

    boolean existsByTittle(String tittle);

    List<Essay> findAllByTagName(String tag);

}
