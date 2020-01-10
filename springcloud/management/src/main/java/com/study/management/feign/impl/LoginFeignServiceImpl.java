package com.study.management.feign.impl;

import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;
import com.study.management.feign.LoginFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName : LoginFeignServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/10
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class LoginFeignServiceImpl  implements FallbackFactory<LoginFeignService> {

    @Override
    public LoginFeignService create(Throwable throwable) {

        log.error("调用base 服务出错。出错原因为：{}",throwable.getMessage());
        return new LoginFeignService() {
            @Override
            public Result login(LoginReqVo LoginReqVo) {
                log.error("登录调用base 出错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }

            @Override
            public Result<CurrentUser> check(String token) {
                log.error("登录调用base 出错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }

            @Override
            public Result exist(String token) {
                log.error("登录调用base 出错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }
        };
    }
}
