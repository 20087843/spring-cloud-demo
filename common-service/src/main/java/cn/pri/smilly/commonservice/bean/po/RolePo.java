package cn.pri.smilly.commonservice.bean.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RolePo {
    private Integer id;
    private String name;
    private String value;
    private String tips;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
