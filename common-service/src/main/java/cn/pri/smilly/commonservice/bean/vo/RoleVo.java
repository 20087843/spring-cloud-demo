package cn.pri.smilly.commonservice.bean.vo;

import cn.pri.smilly.commonservice.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleVo  extends BaseBean {
    private Integer id;
    private String name;
    private String value;
    private String tips;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
