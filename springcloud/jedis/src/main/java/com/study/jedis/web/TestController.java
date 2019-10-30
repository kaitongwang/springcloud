package com.study.jedis.web;

import com.study.common.base.Result;
import com.study.jedis.domain.vo.User;
import com.study.jedis.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : TestController
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/30
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Api("jedis 测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("添加用户信息")
    @PostMapping("/add")
    public Result addUser(@RequestBody User user){
     return    testService.addUser(user);
    }
    @ApiOperation("获取用户信息")
    @PostMapping("/get")
    public Result getUser(@RequestParam  String userName){
        return    testService.getUser(userName);
    }
}
