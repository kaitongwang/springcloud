package com.study.management.domain.config;

import com.alibaba.fastjson.JSONObject;
import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.management.domain.vo.CurrentUserLocal;
import com.study.management.service.LoginService;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName : LoginAuthenticationInterceptor
 * @description : 必须登录的拦截器
 * @Author : wangkaitong
 * @Date : 2019/8/16
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Component
public class LoginAuthenticationInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(LoginAuthenticationInterceptor.class);

    @Lazy
    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        log.info("进入login拦截器");
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        String token = httpServletRequest.getParameter("token");
        if(org.apache.commons.lang.StringUtils.isEmpty(token)){
            token = httpServletRequest.getHeader("token");
        }

        log.info("Login当前传入的token:{}",token);

        if(StringUtils.isNotEmpty(token)){
            Result<CurrentUser> check = loginService.check(token);
            if(check.getCode()!=0){
                returnJson(httpServletResponse,check);
                return false;
            }else {
                CurrentUserLocal.setFilterThreadLocal(check.getResult());
                return  true;
            }


        } else{

            return  false;
        }
    }
    public void returnJson(HttpServletResponse response,Result result){
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
            response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

            writer = response.getWriter();
            writer.print(JSONObject.toJSON(result));
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }
}
