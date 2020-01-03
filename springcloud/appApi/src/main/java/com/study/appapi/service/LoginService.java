package com.study.appapi.service;

import com.study.appapi.domain.req.LoginReqVo;
import com.study.appapi.domain.req.RegistereReqVo;
import com.study.common.base.Result;

/**
 * @ClassName : LoginService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface LoginService {

    /**
     * 用户登录
     * @param reqVo
     * @return
     */
    Result login(LoginReqVo reqVo);

    /**
     * 登录控制器发送验证码
     * @param phone
     * @return
     */
    Result loginSendCode(String phone);

    /**
     * 注册发送验证码
     * @param phone
     * @return
     */
    Result sendCode(String phone);


    /**
     * 用户注册
     * @param registereReqVo
     * @return
     */
    Result registere(RegistereReqVo registereReqVo);
}
