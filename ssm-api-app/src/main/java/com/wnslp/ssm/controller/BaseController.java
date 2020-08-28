package com.wnslp.ssm.controller;


import com.wnslp.ssm.common.result.ApiResult;

import java.io.Serializable;

@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public abstract class BaseController {

    // @InitBinder
    // public void initBinder(ServletRequestDataBinder binder) {
    //     List<DateFormat> dateFormats = new LinkedList<>();
    //     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    //     dateFormats.add(new SimpleDateFormat("yyyy-MM-dd"));
    //
    //     // binder.registerCustomEditor(LocalDateTime.class, new MultiJSR310ParseEditor());
    //     binder.registerCustomEditor(Date.class, new MultiDateParseEditor(dateFormats, true));
    //     binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    // }

    protected <T extends Serializable> ApiResult<T> ok(T data) {
        return ApiResult.Builder.<T>newBuilder().ok(data).build();
    }

    protected <T extends Serializable> ApiResult<T> fail(int errCode) {
        return fail(errCode, null);
    }

    @SuppressWarnings({"SameParameterValue"})
    protected <T extends Serializable> ApiResult<T> fail(int errCode, String message) {
        return ApiResult.Builder.<T>newBuilder().fail(errCode, message).build();
    }
}
