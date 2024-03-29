package com.anofinda.anoblog.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author dongyudeng
 */
public class JwtToken implements AuthenticationToken {
    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
