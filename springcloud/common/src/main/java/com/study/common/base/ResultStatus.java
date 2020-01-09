package com.study.common.base;

/**
 * 描述: 异常枚举类型
 *
 * @Author;chenbo
 * @Date;2019/7/18
 * @Version;1.0
 * @Senice;1.0
 */
public enum ResultStatus {



    SUCCESS(0,"操作成功"),

    SYSTEM_ERROR(9,"系统休息了"),

    //登录控制器
    NO_USERINFO(10,"此用户不存在"),
    USERINFO_DISABLE(11,"此用户已被禁用无法登录"),
    USERINFO_DELETE(12,"此用户已被删除"),
    PASSWORD_ERROR(13,"密码错误"),

    //注册异常
    USER_ISEXIST(21,"此手机号码已被注册"),
    SEND_CODE_ERROR(22,"发送验证码失败"),

    //验证码
    CODE_NOTEXIST(31,"验证码失效"),
    CODE_ISFALSE(32,"验证码错误"),



    //鉴权设置
    NO_LOGIN_USER(41,"未登录无法操作"),
    LOGIN_NO_USER (42,"登录身份已过期，请重新登录"),


    //管理员管理
    ISEXIST_LEADER(51,"此账户已被使用"),

;
    private Integer code;
    private String message;

    ResultStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
