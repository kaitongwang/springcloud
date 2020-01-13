package com.study.management.feign;


import com.study.common.base.Result;
import com.study.management.feign.impl.HomeFeignServiceImpl;
import com.study.management.feign.impl.LeaderFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "base",fallbackFactory = HomeFeignServiceImpl.class)
public interface HomeFeignService {



    @GetMapping("/home/get")
    Result getHomePicture();


}
