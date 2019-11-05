package cn.pri.smilly.authservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Optional;

public class JwtTokenUtil {

    public static final String TOKEN_HEADER = "gtboot";
    public static final String TOKEN_PREFIX = "gtboot ";
    private static final String SECRET = "jwt_secret_gtboot";
    private static final String ISS = "gtboot";
    private static final long EXPIRATION = 1800L;

    public static String createToken(String issuer, String subject, long expiration) {
        return createToken(issuer, subject, expiration, null);
    }

    /**
     * 创建 token
     *
     * @param issuer     签发人
     * @param subject    主体,即用户信息的JSON
     * @param expiration 有效时间(秒)
     * @param claims     自定义参数
     * @return
     */
    public static String createToken(String issuer, String subject, long expiration, Claims claims) {
        return Jwts.builder()
//                .setId(id)  // JWT_ID：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .signWith(SignatureAlgorithm.HS512, SECRET) // 签名算法以及密匙
                .setClaims(claims)
                .setSubject(subject)
//                .setAudience(loginName) // 受众
                .setIssuer(Optional.ofNullable(issuer).orElse(ISS))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (expiration > 0 ? expiration : EXPIRATION) * 1000))
                .compact();
    }

    /**
     * 从 token 中获取主题信息
     *
     * @param token
     * @return
     */
    public static String getSubject(String token) {
        return getTokenBody(token).getSubject();
    }


    /**
     * 校验是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 获得 token 的 body
     *
     * @param token
     * @return
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

}
