package com.anofinda.anoblog.util;

import com.anofinda.anoblog.config.JwtConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dongyudeng
 */
@Slf4j
@Component
public class JwtUtil {

    @Autowired
    JwtConfiguration jwtConfiguration;


}
