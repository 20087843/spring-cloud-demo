package cn.pri.smilly.commonservice.bean.vo;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsVo extends BaseBean {
    private String id;
    private String name;
    private int qty;
    private String unit;
    private double wgt;
}
