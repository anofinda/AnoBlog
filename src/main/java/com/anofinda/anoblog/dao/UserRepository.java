package com.anofinda.anoblog.dao;

import com.anofinda.anoblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author dongyudeng
 */
@Component
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
