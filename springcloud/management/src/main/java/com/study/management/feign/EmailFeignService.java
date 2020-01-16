package com.study.management.feign;

import com.study.common.base.Result;
import com.study.common.vo.base.EmailListReqVo;
import com.study.common.vo.base.EmailVo;
import com.study.management.feign.impl.EmailFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName : EmailFeignService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/16
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@FeignClient(value = "base", fallbackFactory = EmailFeignServiceImpl.class)
public interface EmailFeignService {

    @PostMapping("/email/add")
    Result add(@RequestBody EmailVo emailVo);


    @PostMapping("/email/getList")
    Result getList(@RequestBody EmailListReqVo emailListReqVo);
}
