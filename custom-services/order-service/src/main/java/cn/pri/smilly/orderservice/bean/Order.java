package cn.pri.smilly.orderservice.bean;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order extends BaseBean {
    private String id;
    private User user;
    private List<Goods> goodsList;
}
