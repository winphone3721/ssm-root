package com.wnslp.ssm.common.result;

public enum ApiErrorCode {
    OK(0, "通过"),
    MISSING_PARAMS(1, "参数错误"),
    NOT_FOUND(2, "已拒绝"),
    SERVER_ERROR(3,"服务器异常"),
    QUERY_FAIL(4,"查询失败"),
    INVALID_FORMAT(5,""),
    ALREADY_EXISTS(6,""),
    INSERT_FAIL(6,""),
    API_DISABLED(6,""),
    UNAUTHORIZED(6,""),
    UPDATE_FAIL(6,""),
    REQUEST_FAILURE(3, "请求失败");
    // 成员变量
    private int value;
    private String name;

    // 构造方法
    ApiErrorCode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
