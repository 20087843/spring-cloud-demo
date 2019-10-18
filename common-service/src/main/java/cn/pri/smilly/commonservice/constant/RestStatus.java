package cn.pri.smilly.commonservice.constant;

import lombok.Getter;

@Getter
public enum RestStatus {
    OK(0),
    FAIL(1),
    ERR(99);

    private int code;

    RestStatus(int code) {
        this.code = code;
    }
}
