package cn.pri.smilly.commonservice.bean;

import cn.pri.smilly.commonservice.utils.ConvertUtil;

import java.io.Serializable;

public abstract class BaseBean implements Serializable {

    public <T> T convert(Class<T> clazz) {
        return ConvertUtil.bean2bean(this, clazz);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : " + ConvertUtil.bean2json(this);
    }
}
