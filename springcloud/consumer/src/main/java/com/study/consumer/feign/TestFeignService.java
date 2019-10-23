package com.study.consumer.feign;

import com.study.common.result.Result;
import com.study.common.vo.test.User;
import com.study.consumer.feign.impl.TestFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName : TestFeignService
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@FeignClient(value = "produce",fallback = TestFeignServiceImpl.class)
public interface TestFeignService {

    /**
     *
     * @return
     */
    @GetMapping("/test/get")
    Result<User> get();


}
