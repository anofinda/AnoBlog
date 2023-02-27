package com.anofinda.anoblog.shiro;

import com.anofinda.anoblog.entity.User;
import com.anofinda.anoblog.service.UserService;
import com.anofinda.anoblog.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dongyudeng
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken token = (JwtToken) authenticationToken;
        String username = JwtUtils.getClaims((String) token.getPrincipal()).getAudience();
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("user not exists");
        }
        if (user.getStatus() == -1) {
            throw new LockedAccountException("user is locked");
        }
        return new SimpleAuthenticationInfo(user, token.getCredentials() , user.getUsername());
    }
}
