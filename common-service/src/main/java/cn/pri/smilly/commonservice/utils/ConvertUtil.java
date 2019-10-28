package cn.pri.smilly.commonservice.utils;

import com.alibaba.fastjson.JSON;

public abstract class ConvertUtil {

    public static String bean2json(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T json2bean(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static <S, T> T bean2bean(S object, Class<T> clazz) {
        return json2bean(bean2json(object), clazz);
    }
}
