package com.study.common.result;

/**
 * 描述: 异常枚举类型
 *
 * @Author;chenbo
 * @Date;2019/7/18
 * @Version;1.0
 * @Senice;1.0
 */
public enum ResultStatus {

    /**
     * 系统异常
     */
    HANDLE_SUCCESS(0,"操作成功"),
    SYSTEM_EXCEPTION(1,"系统休息了"),
    SYSTEM_RUNTIMEEXCEPTION(2,"出现未知异常"),
    SYSTEM_OUTAGE(5,"系统休息了"),

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
