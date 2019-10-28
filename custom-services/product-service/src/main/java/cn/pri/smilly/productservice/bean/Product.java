package cn.pri.smilly.productservice.bean;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseBean {
    private String id;
    private String name;
    private double price;
    private String material;
    private String oem;
    private String dtime;
}
