package com.study.common.exception;

import com.study.common.result.ResultStatus;

/**
 * @ClassName : StudyException
 * @description : 定义全局异常处理
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public class StudyException extends RuntimeException {

    private int  code;


    private String  message;



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StudyException(ResultStatus resultStatus) {
        super(resultStatus.getMessage());
        this.code = resultStatus.getCode();
        this.message=resultStatus.getMessage();
    }
}
