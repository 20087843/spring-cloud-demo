package cn.pri.smilly.commonservice.bean;

import cn.pri.smilly.commonservice.constant.RestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestResult extends BaseBean {
    private int status;
    private int code;
    private String msg;
    private Object data;

    public static RestResult build(int status, int code, String msg, Object data) {
        return new RestResult(status, code, msg, data);
    }

    public static RestResult success(Object data) {
        return build(200, RestStatus.SUCCESS.getCode(), RestStatus.SUCCESS.getMsg(), data);
    }

    public static RestResult fail(RestStatus status, String msg) {
        return build(500, status.getCode(), status.getMsg() + msg, null);
    }

}
