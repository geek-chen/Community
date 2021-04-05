package com.majiang.community.exception;

import java.lang.annotation.Target;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不存在！"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2002, "当前操作需要登录，请登录"),
    SYSTEM_ERROR(2004, "服务器出错！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"你操作的评论不存在");
    private String message;
    private  Integer code;

    CustomizeErrorCode(Integer code, String message) {

        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
