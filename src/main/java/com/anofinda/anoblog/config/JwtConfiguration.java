package com.anofinda.anoblog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author dongyudeng
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "blog.jwt")
public class JwtConfiguration {
    private long expire;
    private String header;
    private String secret;
}
