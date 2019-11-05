package cn.pri.smilly.authservice.controller;

import cn.pri.smilly.authservice.utils.VerifyCodeUtils;
import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class OAuthController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @DeleteMapping(value = "/exit")
    public RestResult revokeToken(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return RestResult.success(null);
        } else {
            return RestResult.fail(RestStatus.SVRERR, "token revoke failed");
        }
    }

    @GetMapping(value = "/user", produces = "application/json")
    public RestResult getUser(OAuth2Authentication oAuth) {
        Map<String, Object> user = new HashMap<>();
        user.put("user", oAuth.getPrincipal());
        user.put("authorities", oAuth.getUserAuthentication().getAuthorities());
        return RestResult.success(user);
    }

    @GetMapping(value = "/verify.img", produces = "application/img")
    public void getVerifyCode(HttpServletResponse response) throws IOException {
        /*禁止缓存*/
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        /*获取验证码*/
        String code = VerifyCodeUtils.generateVerifyCode(4);
        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("captcha", uuid);
        /*key写入cookie，验证时获取*/
        response.addCookie(cookie);
        ServletOutputStream outputStream = response.getOutputStream();
        VerifyCodeUtils.outputImage(110, 40, outputStream, code);
        outputStream.flush();
        outputStream.close();
    }

}
