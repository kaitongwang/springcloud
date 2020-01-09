package com.study.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.study.base.domain.dto.Leader;
import com.study.base.domain.request.LeaderListReqVo;
import com.study.base.mapper.LeaderMapper;
import com.study.base.service.LeaderService;
import com.study.common.base.BasePage;
import com.study.common.base.PageUtil;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private LeaderMapper leaderMapper;

    @Override
    public Result getList(LeaderListReqVo leaderListReqVo) {

        PageHelper.startPage(leaderListReqVo.getPage(),leaderListReqVo.getLimit());
        List<Leader> list = leaderMapper.getList();
        BasePage pageList = PageUtil.getPageList(leaderListReqVo.getPage(), list);

        return Result.returnSuccess(pageList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(Leader leader) {
        log.info("添加领导：{}",leader.getAccount());
        //设置默认值
        leader.setCreateTime(new Date());
        leader.setUpdateTime(new Date());
        //检查是否已经存在账户
        int i = leaderMapper.checkAccount(leader.getAccount(), null);
        if(i>0){
            log.info("此账户信息已经存在");
            return Result.resultFail(ResultStatus.ISEXIST_LEADER);
        }
         // 对密码加密 获取32位的盐
        leader.setSalt(UUID.randomUUID().toString().replace("_",""));
        leader.setPassword(DigestUtils.md5DigestAsHex((leader.getPassword()+leader.getSalt()).getBytes()));
        leaderMapper.insert(leader);

        return Result.returnSuccess();
    }
}
