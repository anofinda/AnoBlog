package com.anofinda.anoblog.service;

import com.anofinda.anoblog.dao.UserRepository;
import com.anofinda.anoblog.entity.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author dongyudeng
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Nullable
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
