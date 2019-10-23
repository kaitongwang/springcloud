package com.study.consumer.service.impl;

import com.alibaba.fastjson.JSON;
import com.study.common.result.Result;
import com.study.common.vo.test.User;
import com.study.consumer.feign.TestFeignService;
import com.study.consumer.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : TestServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestFeignService testFeignService;

    @Override
    public Result<User> get() {

        log.info("请求用户信息");
        Result<User> userResult = testFeignService.get();
        log.info("请求用户信息返回为", JSON.toJSONString(userResult));
        return userResult;
    }
}
