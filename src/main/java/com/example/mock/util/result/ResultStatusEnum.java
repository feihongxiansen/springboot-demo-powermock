package com.example.mock.util.result;

/**
 * 请求状态返回值枚举类
 *
 * @author zhufeihong
 * @since 2021/03/16
 */
public enum ResultStatusEnum {

    /**
     * 常用请求状态码
     */
    SUCCESS(200, "成功"),
    FAILED_REQUEST(500, "请求错误"),
    NOT_FOUND(404, "路径不存在"),
    BAD_REQUEST(400, "请求无效");

    /**
     * 请求状态码
     */
    private final Integer code;

    /**
     * 返回提示信息或者错误信息
     */
    private final String msg;

    ResultStatusEnum(Integer index, String desc) {
        this.code = index;
        this.msg = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
