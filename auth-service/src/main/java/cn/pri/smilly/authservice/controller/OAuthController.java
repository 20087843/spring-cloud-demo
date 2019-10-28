package cn.pri.smilly.authservice.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class OAuthController {

    @GetMapping(value = "/user", produces = "application/json")
    public Map<String, Object> getUser(OAuth2Authentication oAuth) {
        Map<String, Object> user = new HashMap<>();
        user.put("user", oAuth.getPrincipal());
        user.put("authorities", oAuth.getUserAuthentication().getAuthorities());
        return user;
    }

}
