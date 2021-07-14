package com.xf.jwtuser.context;


import com.xf.jwtuser.entity.LoginUser;

/**
 * <p>
 *
 * </p>
 *
 * @author xf
 * @date 2021-07-06
 */
public class LoginUserHolder {

    private static final ThreadLocal<Boolean> OPEN_UP_FLAG = new ThreadLocal();
    private static final ThreadLocal<LoginUser> LONGIN_USER_HOLDER = new ThreadLocal();

    public LoginUserHolder() {
    }

    public static void init() {
        OPEN_UP_FLAG.set(true);
    }

    public static void set(LoginUser abstractLoginUser) {
        Boolean openUpFlag = (Boolean)OPEN_UP_FLAG.get();
        if (openUpFlag != null && !openUpFlag.equals(false)) {
            LONGIN_USER_HOLDER.set(abstractLoginUser);
        }
    }

    public static LoginUser get() {
        Boolean openUpFlag = (Boolean)OPEN_UP_FLAG.get();
        return openUpFlag != null && !openUpFlag.equals(false) ? (LoginUser)LONGIN_USER_HOLDER.get() : null;
    }

    public static void remove() {
        OPEN_UP_FLAG.remove();
        LONGIN_USER_HOLDER.remove();
    }


}
