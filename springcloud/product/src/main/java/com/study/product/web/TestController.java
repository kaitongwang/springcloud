package com.study.product.web;

import com.study.common.result.Result;
import com.study.common.vo.test.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TestController
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Api(description = "测试接口")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @ApiOperation(value = "获取用户信息")
    @GetMapping("/get")
    public Result<User>  getUser(){
        User wkt = new User(1,"wkt");
        log.info("查询用户信息为：{}",wkt);
        return Result.returnSuccess(wkt);
    }
}
