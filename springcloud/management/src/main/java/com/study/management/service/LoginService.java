package com.study.management.service;

import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;

/**
 * @ClassName : LoginService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */

public interface LoginService {

    /**
     * 登录
     * @param loginReqVo
     * @return
     */
    Result login(LoginReqVo loginReqVo);


    Result exist();


    /**
     * 检查用户信息是否有效
     * @param token
     * @return
     */
    Result<CurrentUser> check(String token);
}
