package cn.pri.smilly.commonservice.bean.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MenuPo {
    private Integer id;
    private String code;
    private String pCode;
    private String pId;
    private String name;
    private String url;
    private Integer isMenu;
    private Integer level;
    private Integer sort;
    private Integer status;
    private String icon;
    private Date createTime;
    private Date updateTime;
}
