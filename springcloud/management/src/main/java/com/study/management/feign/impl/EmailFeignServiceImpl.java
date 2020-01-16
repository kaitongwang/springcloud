package com.study.management.feign.impl;

import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import com.study.common.vo.base.EmailListReqVo;
import com.study.common.vo.base.EmailVo;
import com.study.management.feign.EmailFeignService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName : EmailFeignServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/16
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class EmailFeignServiceImpl implements FallbackFactory<EmailFeignService> {
    @Override
    public EmailFeignService create(Throwable throwable) {
        log.error("调用base 服务出错");
        return new EmailFeignService() {
            @Override
            public Result add(EmailVo emailVo) {
                log.error("添加邮箱报错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }

            @Override
            public Result getList(EmailListReqVo emailListReqVo) {
                log.error("列表查询报错");
                return Result.resultFail(ResultStatus.SYSTEM_ERROR);
            }
        };
    }
}
