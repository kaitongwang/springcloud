package com.study.base.web;

import com.study.common.base.Result;
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
 * @Date : 2019/10/29
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */

@Slf4j
@RestController
@RequestMapping("/test")
@Api(description = "测试地址信息")
public class TestController {


    @ApiOperation("测试接口")
    @GetMapping("/get")
    public Result get(){
        log.info("调用测试接口");
        return Result.returnSuccess();
    }
}
