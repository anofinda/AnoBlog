package com.anofinda.anoblog.dao;

import com.anofinda.anoblog.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author dongyudeng
 */
@Component
public interface TypeRepository extends JpaRepository<Type, Long> {

}
