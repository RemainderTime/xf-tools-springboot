package com.xf.jwtuser.context;

import cn.hutool.core.bean.BeanUtil;
import com.xf.jwtuser.entity.LoginUser;
import com.xf.jwtuser.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  用户登录上下文类
 * </p>
 *
 * @author xf
 * @date 2021-07-06
 */
public class LoginContext {

    //自定义jwt私钥
    private static String jwtSecret = "remaindertime";
    //jwt过期时间（秒）
    private static Long  jwtATExpiredDate = 60L;
    private JwtTokenUtil jwtTokenUtil;
    private static LoginContext loginContext = null;

    //通过构造方法创建  jwtTokenUtil 对象
    public LoginContext(String jwtSecret,Long jwtATExpiredDate) {
        this.jwtTokenUtil = new JwtTokenUtil(jwtSecret, jwtATExpiredDate);
    }

    //构建 LoginContext 对象
    public static LoginContext me() {
            if(loginContext == null){
                loginContext = new LoginContext(jwtSecret,jwtATExpiredDate);
            }
        return loginContext;
    }

    /**
     * 登录成功后设置用户数据到jwt中
     * @param user 用户对象
     * @return 返回token
     */
    public String generateToken(LoginUser user) {
        HashMap<String, Object> claims = new HashMap();
        claims.put("user", user);
        return this.jwtTokenUtil.generateToken(user.getId().toString(), claims);
    }

    /**
     * 获取当前登录用户基本信息对象
     * @return
     */
    public LoginUser getLoginUserNoException() {
        LoginUser currentUser = LoginUserHolder.get();
        if (currentUser != null) {
            return currentUser;
        } else {
            String token = this.getCurrentUserTokenReal();
            if (token != null) {
                 currentUser = this.getUserFromToken(token);
                if (currentUser != null) {
                    LoginUserHolder.set(currentUser);
                }
                return currentUser;
            } else {
                return null;
            }
        }
    }

    /**
     * 通过token解析用户信息对象
     * @param token
     * @return
     */
    public LoginUser getUserFromToken(String token) {
        Claims claimFromToken = this.jwtTokenUtil.getClaimFromToken(token);
        Map mapUser = claimFromToken.get("user", Map.class);
        return  BeanUtil.mapToBean(mapUser, LoginUser.class, false);
    }


    /**
     * 获取当前请求下 请求头中的 Authorization 或者 请求参数中 token值
     * @return
     */
    public String getCurrentUserTokenReal() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String token;
        if (request != null) {
            String authToken = request.getHeader("Authorization");
            if (!StringUtils.isEmpty(authToken)) {
                return authToken;
            }
            token = request.getParameter("token");
            if (!StringUtils.isEmpty(token)) {
                return token;
            }
        }
        return null;
    }


}
