package com.study.base.mapper;


import com.study.base.domain.config.BaseMapper;
import com.study.base.domain.dto.Leader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LeaderMapper  extends BaseMapper<Leader> {


    List<Leader> getList();
}