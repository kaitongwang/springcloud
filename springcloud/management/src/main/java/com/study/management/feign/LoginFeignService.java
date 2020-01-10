package com.study.management.feign;

import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.LoginReqVo;
import com.study.management.feign.impl.LoginFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName : LoginFeignService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/10
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@FeignClient(value = "base",fallbackFactory = LoginFeignServiceImpl.class)
public interface LoginFeignService  {

    @PostMapping("/login/login")
    Result login(@RequestBody LoginReqVo LoginReqVo);
    @PostMapping("/login/check")
    Result<CurrentUser> check(@RequestParam("token") String token);


    @PostMapping("/login/exist")
    Result exist(@RequestParam("token") String token);
}
