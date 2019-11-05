package cn.pri.smilly.commonservice.bean;

import cn.pri.smilly.commonservice.constant.RestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestResult extends BaseBean {
    private int code;
    private String msg;
    private Object data;

    public static RestResult build(RestStatus status, String msg, Object data) {
        return new RestResult(status.getCode(), msg, data);
    }

    public static RestResult success(Object data) {
        return build(RestStatus.SUCCESS, RestStatus.SUCCESS.getMsg(), data);
    }

    public static RestResult fail(RestStatus status, String msg) {
        return build(status, status.getMsg() + msg, null);
    }

}
