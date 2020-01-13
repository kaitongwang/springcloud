package com.study.base.mapper;


import com.study.base.domain.config.BaseMapper;
import com.study.base.domain.dto.EmailLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmailLogMapper extends BaseMapper<EmailLog> {
}