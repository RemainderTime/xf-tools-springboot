package com.xf.jwtuser.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 *   jwt工具类
 * </p>
 *
 * @author xf
 * @date 2021-07-06
 */
public class JwtTokenUtil {

    /**
     * jwt密匙
     */
    private String jwtSecret;
    /**
     * 默认过期时间
     */
    private Long defaultExpiredDate;

    public JwtTokenUtil(String jwtSecret, Long defaultExpiredDate) {
        this.jwtSecret = jwtSecret;
        this.defaultExpiredDate = defaultExpiredDate;
    }

    /**
     * 设置用户jwt对象数据并返回加密token
     * @param userId  用户id
     * @param claims 存储的参数map
     * @return
     */
    public String generateToken(String userId, Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + defaultExpiredDate * 1000L);
        Date createdDate = new Date();
        return claims == null ? Jwts.builder().setSubject(userId).setIssuedAt(createdDate).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact() :
                Jwts.builder().setClaims(claims).setSubject(userId).setIssuedAt(createdDate).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact();
    }

    /**
     * 通过token获取用户对象数据
     * @param token 查询token
     * @return
     */
    public Claims getClaimFromToken(String token) {
        return (Claims)Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token).getBody();
    }

}
