package com.study.consumer.feign.impl;

import com.study.common.result.Result;
import com.study.common.result.ResultStatus;
import com.study.common.vo.test.User;
import com.study.consumer.feign.TestFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName : TestFeignServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class TestFeignServiceImpl implements TestFeignService {

    @Override
    public Result<User> get() {
        log.error("获取用户信息失败，服务降级");
        return  Result.resultFail(ResultStatus.SYSTEM_OUTAGE);
    }
}
