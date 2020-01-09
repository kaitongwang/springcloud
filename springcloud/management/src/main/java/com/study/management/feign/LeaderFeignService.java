package com.study.management.feign;

import com.study.common.base.Result;
import com.study.management.domain.dto.Leader;
import com.study.management.domain.request.LeaderListReqVo;
import com.study.management.feign.impl.LeaderFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName : LeaderFeignService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@FeignClient(value = "base",fallbackFactory = LeaderFeignServiceImpl.class)
public interface LeaderFeignService {

    @PostMapping("/leader/getList")
    Result getList(@RequestBody LeaderListReqVo leaderListReqVo);

    @PostMapping ("/leader/add")
    Result add(@RequestBody Leader leader);
}
