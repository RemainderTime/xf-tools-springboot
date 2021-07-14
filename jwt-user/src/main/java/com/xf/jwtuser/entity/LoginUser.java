package com.xf.jwtuser.entity;

import lombok.Data;

/**
 * <p>
 *   用户信息对象实体类
 * </p>
 *
 * @author xf
 * @date 2021-07-06
 */
@Data
public class LoginUser {

    private Long id;

    private String name;

    private String pwd;

}
