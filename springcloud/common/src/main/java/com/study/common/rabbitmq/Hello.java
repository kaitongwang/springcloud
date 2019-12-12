package com.study.common.rabbitmq;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName : Hello
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class Hello implements Serializable {


    private String message;

    private String  text;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;


}
