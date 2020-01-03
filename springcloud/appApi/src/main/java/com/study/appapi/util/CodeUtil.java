package com.study.appapi.util;

import java.util.UUID;

/**
 * @ClassName : CodeUtil
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public class CodeUtil {


    public static  String getCode(){
         return   ((int)(Math.random() * 9 + 1) * 100000)+"";
    }

    public static  String getSalt(){
        return UUID.randomUUID().toString().replace("_","");
    }
}
