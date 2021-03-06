package com.study.base.service;

import com.study.base.web.LoginController;
import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;
import org.springframework.web.bind.annotation.RequestParam;

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
    Result login( LoginReqVo loginReqVo);


    /**
     * 检查用户信息是否有效
     * @param token
     * @return
     */
    Result<CurrentUser> check(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result exist(String token);

}
