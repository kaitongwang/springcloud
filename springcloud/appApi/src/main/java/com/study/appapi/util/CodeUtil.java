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


    /**
     * 生产验证码
     *
     * @param size 验证码位数
     */
    public static String generateNewAuthCode(Integer size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(randomInt(0, 9));
        }
        return sb.toString();
    }

    /**
     * 产生0-9的随机数
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max) {
        return (int)Math.round(Math.random() * (double)(max - min) + (double)min);
    }

    public static  String getSalt(){
        return UUID.randomUUID().toString().replace("_","");
    }
}
