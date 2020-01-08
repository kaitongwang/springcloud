package com.study.base.web;

import com.study.base.domain.request.LeaderListReqVo;
import com.study.base.service.LeaderService;
import com.study.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : LeaderController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/8
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RequestMapping("/leader")
@RestController
public class LeaderController {


    @Autowired
    private LeaderService leaderService;

    @PostMapping("/getList")
    public Result getList(@RequestBody LeaderListReqVo leaderListReqVo){

        return leaderService.getList(leaderListReqVo);
    }
}
