package com.study.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * @ClassName : MD5Util
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public class MD5Util {


    /**
     * 对参数直接MD5加密
     * @param param
     * @return
     */
    public  static String MD5(String param){

        return DigestUtils.md5DigestAsHex(param.getBytes());
    }

    /**
     * 携带盐的MD5加密（盐在后）
     * @param param 参数
     * @param salt 盐
     * @return
     */

    public  static String MD5AfterSalt(String param,String salt){

      return DigestUtils.md5DigestAsHex((param+salt).getBytes());
    }


    /**
     * 携带盐的MD5加密（盐在前）
     *
     * @param salt 盐
     * @param param 参数
     * @return
     */

    public  static String MD5BeforeSalt(String salt,String param){

        return DigestUtils.md5DigestAsHex((salt+param).getBytes());
    }


    /**
     *
     * 对加密前跟加密后的值做判断
     * @param param1  加密前参数
     * @param salt 盐
     * @param param2 加密后参数
     * @return
     */
    public  static Boolean MD5Equal(String param1,String salt,String param2){

        String s = DigestUtils.md5DigestAsHex((param1 + salt).getBytes());
        return StringUtils.equals(param2,s);
    }


}
