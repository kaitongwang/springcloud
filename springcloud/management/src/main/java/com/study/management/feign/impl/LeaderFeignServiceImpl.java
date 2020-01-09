package com.study.management.feign.impl;

import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import com.study.management.domain.request.LeaderListReqVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import com.study.management.domain.dto.Leader;
import com.study.management.feign.LeaderFeignService;
import org.springframework.stereotype.Service;

/**
 * @ClassName : LeaderFeignServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class LeaderFeignServiceImpl implements FallbackFactory<LeaderFeignService> {

    @Override
    public LeaderFeignService create(Throwable throwable) {
        log.error("服务发生降级，降级原因为：{}", throwable.getMessage());
        return new LeaderFeignService() {
            @Override
            public Result getList(LeaderListReqVo leaderListReqVo) {
                log.error("查询领导出错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }

            @Override
            public Result add(Leader leader) {
                log.error("添加领导报错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }
        };
    }
}
