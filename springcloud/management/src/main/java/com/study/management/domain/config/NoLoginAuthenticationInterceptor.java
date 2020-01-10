package com.study.management.domain.config;

import com.study.management.domain.vo.CurrentUserLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname: AuthenticationInterceptor
 * 描述: 不需要登录也可以操作的拦截器
 * @Author: Kt.w
 * @Date: 2019/7/23
 * @Version 1.0
 * @Since 1.0
 */

@Component
public class NoLoginAuthenticationInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(NoLoginAuthenticationInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        CurrentUserLocal.setFilterThreadLocal(null);
        return true;
    }
}
