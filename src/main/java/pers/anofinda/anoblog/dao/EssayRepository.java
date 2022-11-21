package pers.anofinda.anoblog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import pers.anofinda.anoblog.entity.Essay;

import java.util.Optional;

/**
 * @author dongyudeng
 */
public interface EssayRepository extends PagingAndSortingRepository<Essay, Long> {

    Optional<Essay> findByTitle(String title);

    boolean existsByTitle(String tittle);

}
