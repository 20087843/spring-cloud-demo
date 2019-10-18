package cn.pri.smilly.commonservice.bean;

import cn.pri.smilly.commonservice.constant.RestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class RestResult extends BaseBean implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public static RestResult build(RestStatus status, String msg, Object data) {
        return new RestResult(status.getCode(), msg, data);
    }
}
