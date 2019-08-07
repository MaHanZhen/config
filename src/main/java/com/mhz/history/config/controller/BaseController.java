package com.mhz.history.config.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class BaseController {

    public HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }

    public HttpSession getSession() {
        return getRequest().getSession(true);
    }

    public Object getSessionParameter(String key){
        return getSession().getAttribute(key);
    }

    public Cookie[] getCookie(){
        return getRequest().getCookies();
    }


    public String getRequestParameter(String key) {
        return this.getRequest().getParameter(key);
    }


    public Pageable getPageRequest() {
        String pageStr =getRequestParameter("page");
        String limitStr = getRequestParameter("limit");

        Integer page,limit;
        if(StringUtils.isEmpty(pageStr) || "1".equals(pageStr)){
            page = 0;
        }else{
            page = Integer.parseInt(pageStr)-1;
        }

        if(StringUtils.isEmpty(limitStr)){
            limit = 20;
        }else{
            limit = Integer.parseInt(limitStr);
        }

        return PageRequest.of(page, limit);
    }


}
