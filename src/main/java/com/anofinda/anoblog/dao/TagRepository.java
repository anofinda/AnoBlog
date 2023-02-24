package com.anofinda.anoblog.dao;

import com.anofinda.anoblog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author dongyudeng
 */
@Component
public interface TagRepository extends JpaRepository<Tag,Long> {
}
