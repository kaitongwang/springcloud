package com.study.common.base;

/**
 * 描述:  通用返回对象
 *
 * @Author;wangkaitong
 * @Date;2019/7/18
 * @Version;1.0
 * @Senice;1.0
 */
public  final class Result<T>{

    private Integer code;

    private String message;

    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 不带参数的返回成功
     * @return Result 对象
     */
    public static Result returnSuccess(){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("success");
        return result;
    }

    /**
     *  带参数的返回成功
     * @param data  返回对象
     * @return result 对象
     */
    public static Result returnSuccess(Object data){
        Result result = returnSuccess();
        result.setResult(data);
        return result;
    }

    public static Result resultFail(ResultStatus status){
        Result result = new Result();
        result.setCode(status.getCode());
        result.setMessage(status.getMessage());
        return result;

    }
}
