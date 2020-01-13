package com.study.management.feign.impl;

import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import com.study.management.feign.HomeFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName : HomeFeignServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/13
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class HomeFeignServiceImpl implements FallbackFactory<HomeFeignService> {
    @Override
    public HomeFeignService create(Throwable throwable) {
        log.error("调用base 出错，出错原因为：{}",throwable.getMessage());
        return new HomeFeignService() {
            @Override
            public Result getHomePicture() {
                log.error("获取首页出错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }
        };
    }
}
