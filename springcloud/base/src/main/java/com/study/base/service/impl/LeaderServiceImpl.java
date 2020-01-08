package com.study.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.study.base.domain.dto.Leader;
import com.study.base.domain.request.LeaderListReqVo;
import com.study.base.mapper.LeaderMapper;
import com.study.base.service.LeaderService;
import com.study.common.base.BasePage;
import com.study.common.base.PageUtil;
import com.study.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : LeaderServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/8
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderMapper leaderMapper;

    @Override
    public Result getList(LeaderListReqVo leaderListReqVo) {

        PageHelper.startPage(leaderListReqVo.getPage(),leaderListReqVo.getLimit());
        List<Leader> list = leaderMapper.getList();
        BasePage pageList = PageUtil.getPageList(leaderListReqVo.getPage(), list);

        return Result.returnSuccess(pageList);
    }
}
