package com.study.management.service.impl;

import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;
import com.study.management.domain.vo.CurrentUserLocal;
import com.study.management.feign.LoginFeignService;
import com.study.management.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : LoginServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginFeignService loginFeignService;
    @Override
    public Result login( LoginReqVo loginReqVo) {
     return loginFeignService.login(loginReqVo);
    }

    @Override
    public Result exist() {
        CurrentUser currentAuthToken = CurrentUserLocal.getCurrentAuthToken();
        return loginFeignService.exist(currentAuthToken.getToken());
    }

    @Override
    public Result<CurrentUser> check(String token) {
        return loginFeignService.check(token);
    }
}
