package com.study.base.service;

import com.study.base.domain.request.LeaderListReqVo;
import com.study.common.base.Result;

/**
 * @ClassName : LeaderService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/8
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface LeaderService {

    Result getList(LeaderListReqVo leaderListReqVo);
}
