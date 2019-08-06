package com.mmall.common;

import com.mmall.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: permission
 * @description:
 * @author: Mr.Chen
 * @create: 2019-08-02 17:17
 **/
@Slf4j
public class HttpIntercepter extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI().toString();
        Map parameterMap=request.getParameterMap();
        log.info("request start. url:{},params:{}",url, JsonMapper.obj2String(parameterMap));
        return true;
    }

    @Override
    //正常情况下才会调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url=request.getRequestURI().toString();
        Map parameterMap=request.getParameterMap();
        log.info("request finished. url:{},params:{}",url, JsonMapper.obj2String(parameterMap));
        removeThreadLocalInfo();
    }

    @Override
    //无论什么情况下都会调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        super.afterCompletion(request, response, handler, ex);
        removeThreadLocalInfo();
    }
    public void removeThreadLocalInfo(){
        RequestHolder.remove();

    }
}
