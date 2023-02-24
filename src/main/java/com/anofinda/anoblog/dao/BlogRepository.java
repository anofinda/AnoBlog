package com.anofinda.anoblog.dao;

import com.anofinda.anoblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author dongyudeng
 */
@Component
public interface BlogRepository extends JpaRepository<Blog,Long> {

}
