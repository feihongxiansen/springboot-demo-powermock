package com.example.mock.util.result;

import java.io.Serializable;

/**
 * 接口响应结果统一封装工具类
 *
 * @author zhufeihong
 * @since 2021/03/16
 */
public class Results<T> implements Serializable {

    /**
     * 真正的返回数据
     */
    T data;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 调用是否成功
     */
    private boolean success;

    /**
     * 请求成功方法组
     */
    public static <T> Results<T> success() {
        ResultStatusEnum statusEnum = ResultStatusEnum.SUCCESS;
        return new Results<>(null, statusEnum.getCode(), statusEnum.getMsg(), true);
    }

    public static <T> Results<T> success(ResultStatusEnum statusEnum) {
        return new Results<>(null, statusEnum.getCode(), statusEnum.getMsg(), true);
    }

    public static <T> Results<T> success(String msg) {
        return new Results<>(null, null, msg, true);
    }

    public static <T> Results<T> success(Integer code) {
        return new Results<>(null, code, null, true);
    }

    public static <T> Results<T> success(Integer code, String msg) {
        return new Results<>(null, code, msg, true);
    }

    public static <T> Results<T> successWith(T data) {
        ResultStatusEnum statusEnum = ResultStatusEnum.SUCCESS;
        return new Results<>(data, statusEnum.getCode(), statusEnum.getMsg(), true);
    }

    public static <T> Results<T> successWith(T data, Integer code) {
        return new Results<>(data, code, null, true);
    }

    public static <T> Results<T> successWith(T data, String msg) {
        return new Results<>(data, ResultStatusEnum.SUCCESS.getCode(), msg, true);
    }

    public static <T> Results<T> successWith(T data, Integer code, String msg) {
        return new Results<>(data, code, msg, true);
    }

    public static <T> Results<T> successWith(T data, ResultStatusEnum statusEnum) {
        return new Results<>(data, statusEnum.getCode(), statusEnum.getMsg(), true);
    }


    /**
     * 请求失败方法组
     */
    public static <T> Results<T> failed() {
        ResultStatusEnum statusEnum = ResultStatusEnum.FAILED_REQUEST;
        return new Results<>(null, statusEnum.getCode(), statusEnum.getMsg(), false);
    }

    public static <T> Results<T> failed(String msg) {
        return new Results<>(null, ResultStatusEnum.FAILED_REQUEST.getCode(), msg, false);
    }

    public static <T> Results<T> failed(Integer code) {
        return new Results<>(null, code, null, false);
    }

    public static <T> Results<T> failed(ResultStatusEnum statusEnum) {
        return new Results<>(null, statusEnum.getCode(), statusEnum.getMsg(), false);
    }

    public static <T> Results<T> failed(Integer code, String msg) {
        return new Results<>(null, code, msg, false);
    }

    public static <T> Results<T> failedWith(T data) {
        ResultStatusEnum statusEnum = ResultStatusEnum.FAILED_REQUEST;
        return new Results<>(data, statusEnum.getCode(), statusEnum.getMsg(), false);
    }

    public static <T> Results<T> failedWith(T data, ResultStatusEnum statusEnum) {
        return new Results<>(data, statusEnum.getCode(), statusEnum.getMsg(), false);
    }

    public static <T> Results<T> failedWith(T data, Integer code, String msg) {
        return new Results<>(data, code, msg, false);
    }

    public static <T> Results<T> failedWith(T data, String msg) {
        return new Results<>(data, ResultStatusEnum.FAILED_REQUEST.getCode(), msg, false);
    }

    public static <T> Results<T> failedWith(T data, Integer code) {
        return new Results<>(data, code, null, false);
    }

    private Results(T data, Integer code, String msg, boolean success) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
