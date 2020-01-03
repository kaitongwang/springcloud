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

    Result login(LoginReqVo reqVo);

    Result sendCode(String phone);

    Result registere(RegistereReqVo registereReqVo);
}
