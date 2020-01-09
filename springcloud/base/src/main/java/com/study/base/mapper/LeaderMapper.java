package com.study.base.mapper;


import com.study.base.domain.config.BaseMapper;
import com.study.base.domain.dto.Leader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LeaderMapper  extends BaseMapper<Leader> {


    /**
     * 分页查询
     * @return
     */
    List<Leader> getList();

    /**
     * 检查是否账户已经存在
     * @param account
     * @param id
     * @return
     */
    int  checkAccount(@Param("account") String account, @Param("id") Long id);


    Leader selectByAccount(@Param("account") String account);
}