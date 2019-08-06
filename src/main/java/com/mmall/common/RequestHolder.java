package com.mmall.common;

import com.mmall.model.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-05 18:13
 **/
public class RequestHolder {
    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(SysUser sysUser) {
        userHolder.set(sysUser);
    }

    public static void add(HttpServletRequest httpServletRequest) {
        requestHolder.set(httpServletRequest);
    }

    public static SysUser getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}
