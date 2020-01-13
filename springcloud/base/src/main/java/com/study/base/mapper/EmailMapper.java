package com.study.base.mapper;


import com.study.base.domain.config.BaseMapper;
import com.study.base.domain.dto.entity.Email;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmailMapper extends BaseMapper<Email> {

    /**
     * 查询出要发送邮件的邮箱
     * @return
     */
    List<Email> getSendEmailList();
}