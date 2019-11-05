package cn.pri.smilly.commonservice.bean.vo;

import cn.pri.smilly.commonservice.bean.BaseBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderVo extends BaseBean {
    private String id;
    private User user;
    private List<GoodsVo> goodsList;
}
