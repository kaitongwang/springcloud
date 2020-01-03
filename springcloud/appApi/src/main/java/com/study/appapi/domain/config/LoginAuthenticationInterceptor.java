package com.study.appapi.domain.config;

import com.alibaba.fastjson.JSONObject;
import com.study.appapi.domain.dto.User;
import com.study.appapi.service.CheckUserService;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Component
public class LoginAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private CheckUserService checkUserService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        log.info("进入login拦截器");
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
//            log.info("进入login拦截器OPTIONS");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        String   token = httpServletRequest.getHeader("token");

        log.info("Login当前传入的token:{}",token);

        if(StringUtils.isNotEmpty(token)){
            Result<User> userResult = checkUserService.checkUser(token);
            if(userResult.getCode()!=0){
                returnJson(httpServletResponse,userResult);
                return false;
            }else{
                //用户信息存在在当前线程
                CurrentUser.setFilterThreadLocal(userResult.getResult());
                return true;
            }


        } else{
            log.info("未登录");
            Result result = Result.resultFail(ResultStatus.NO_LOGIN_USER);
            returnJson(httpServletResponse,result);
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
