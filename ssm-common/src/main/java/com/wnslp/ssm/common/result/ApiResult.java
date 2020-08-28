package com.wnslp.ssm.common.result;

import java.io.Serializable;

public class ApiResult<T extends Serializable> {

    private Boolean status;
    private Integer errCode;
    private String message;
    private T data;

    public ApiResult() {
    }

    private ApiResult(Builder builder) {
        this.status = builder.status;
        this.errCode = builder.errCode;
        this.message = builder.message;
        this.data = (T) builder.data;
    }

    public ApiResult(Integer errCode, String message, T data) {
        this.errCode = errCode;
        this.message = message;
        this.data = data;
    }


    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static class Builder<T extends Serializable> {
        private Boolean status;
        private Integer errCode;
        private String message;
        private T data;

        Builder() {
        }

        public Builder(Boolean status, Integer errCode, String message, T data) {
            //super(errCode, message, data);
            this.status = status;
            this.errCode = errCode;
            this.message = message;
            this.data = data;
        }

        public Builder status(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder errCode(Integer errCode) {
            this.errCode = errCode;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder ok(T data) {
            this.status = true;
            this.data = data;
            return this;
        }

        public ApiResult build() {
            return toBuilder();
        }

        public ApiResult toBuilder() {
            return new ApiResult(this);
            //return   (new Builder()).data(this.data).errCode(this.errCode).message(this.message);
            //return new ApiResult.Builder(this.errCode, this.message, this.data);
        }

        public Builder fail(Integer errCode, String message) {
            this.status = false;
            this.errCode = errCode;
            this.message = message;
            return this;
        }

        @Override
        public String toString() {
            return "ApiResult{" +
                    "status=" + status +
                    ", errCode=" + errCode +
                    ", message='" + message + '\'' +
                    ", data=" + data +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "status=" + status +
                ", errCode=" + errCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}