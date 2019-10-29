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

    /**
     * 系统异常
     */
    HANDLE_SUCCESS(0,"操作成功"),
    SYSTEM_EXCEPTION(1,"系统休息了"),
    SYSTEM_RUNTIMEEXCEPTION(2,"出现未知异常"),
    SYSTEM_OUTAGE(5,"系统休息了"),


    PERMISSIONS_FAIL(6,"权限认证失败"),
    // 活动异常枚举
    NAME_IS_EMPTY(10,"请输入活动名称"),
    COMPANY_IS_EMPTY(3,"请输入活动结算主体"),
    DATE_IS_EMPTY(4,"请输入活动日期"),
    IMPORT_EXCEL_ERROR(100,"导入异常"),


    //手机号码验证
    PHONE_ILLEGAL(11,"无效手机号码"),
    CODE_NOT_EXIST(12,"验证码不存在或者已经失效"),
    CODE_NOT_TRUE(13,"验证码不正确"),
    PRODUCT_CHANGE(13,"商品价格发生变化，请在购物车核对价格后，重新添加订单"),

    //支付
    REQUEST_PAY_SCAN(100,"请求支付失败"),

    //银行卡绑定失败
    BING_CARD(101,"银行卡绑定失败"),


    APP_PAY(103,"app请求支付失败"),


    // 参数校验异常
    PARAM_ERROR(120,"参数校验异常"),
    PARAM_NULL(121,"参数为空异常"),


    // 未查询到有效用户
    FAILURE_USER(130,"无效身份"),
    VALID_USER_NOT_EXIST(140,"未查询到有效用户"),
    MOBILE_ERROR(141,"手机号格式不正确"),
    SMS_NOT_EXIST(142,"验证码不存在"),
    SMS_ERROR(143,"验证码错误"),
    ILLEGAL_LOGIN(144,"非法登陆请求"),

    NOT_DATA(150,"未查询到数据"),

    // file
    FILE_BEYOND_LIMIT(160,"文件大小超出1MB限制, 请压缩或降低文件质量!"),

    // token
    TOKEN_EXPIRED(40001,"token expired");

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
