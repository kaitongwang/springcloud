package com.study.appapi.dao.mapper;


import com.study.appapi.dao.BaseMapper;
import com.study.appapi.domain.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper  extends BaseMapper<User> {
    /**
     * 使用账户名查询用户信息
     * @param account
     * @return
     */
    User selectByAccount(@Param("account") String account);

    /**
     *  使用电话号码查询用户信息
     */
    User selectByPhone(@Param("phone") String phone);
}