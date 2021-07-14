package com.xf.jwtuser.controller;

import com.xf.jwtuser.context.LoginContext;
import com.xf.jwtuser.entity.LoginUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author xf
 * @date 2021-07-06
 */
@RestController
public class JwtController {

    /**
     * 模拟用户登录接口
     * @param userName 账号
     * @param pwd 密码
     * @return
     */
    @PostMapping(value = "/login")
    public String login( String userName, String pwd){

        //校验登录密码是否正确（略）
        //...
        //校验成功，保持用户数据到jwt中,并生成token返回给前端
        LoginUser loginUser = new LoginUser();
        loginUser.setId(1L);
        loginUser.setName(userName);
        String s = LoginContext.me().generateToken(loginUser);
        return s;
    }

    /**
     * 获取用户信息名称
     * @return
     */
    @GetMapping(value = "/getUserInfo")
    public String getUserInfo(){
        //通过用户工具类获取用户信息,
        LoginUser user = LoginContext.me().getLoginUserNoException();
        //用户未登录返回提示
        if(user == null){
            return "请登录";
        }
        return user.getName();
    }




}
