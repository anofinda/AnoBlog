package com.anofinda.anoblog.controller;

import com.anofinda.anoblog.common.dto.LoginDto;
import com.anofinda.anoblog.common.lang.Result;
import com.anofinda.anoblog.entity.User;
import com.anofinda.anoblog.service.UserService;
import com.anofinda.anoblog.shiro.JwtToken;
import com.anofinda.anoblog.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongyudeng
 */
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
    private final UserService userService;

    public AdminApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result login(LoginDto loginDto) {
        log.info("user login:" + loginDto.getUsername());
        User user = userService.getUserByUsername(loginDto.getUsername());
        if (user == null) {
            return Result.fail("user not exists");
        }
        if (!user.getPassword().equals(DigestUtils.md5Hex(loginDto.getPassword()))) {
            return Result.fail("wrong password");
        }
        String token = JwtUtils.getToken(user.getUsername());
        Subject subject = SecurityUtils.getSubject();
        subject.login(new JwtToken(token));
        return Result.success(user);
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success("logout success");
    }

    @Profile(value = {"dev", "test"})
    @GetMapping("/test")
    public Result test() {
        return Result.success("Test success");
    }
}
