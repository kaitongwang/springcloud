package com.study.management.service.impl;


import com.study.common.base.Result;
import lombok.extern.slf4j.Slf4j;
import com.study.management.domain.dto.Leader;
import com.study.management.domain.request.LeaderListReqVo;
import com.study.management.feign.LeaderFeignService;
import com.study.management.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : LeaderServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/8
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderFeignService leaderFeignService;


    @Override
    public Result getList(LeaderListReqVo leaderListReqVo) {

        return  leaderFeignService.getList(leaderListReqVo);
    }

    @Override
    public Result add(Leader leader) {
        return  leaderFeignService.add(leader);
    }
}
