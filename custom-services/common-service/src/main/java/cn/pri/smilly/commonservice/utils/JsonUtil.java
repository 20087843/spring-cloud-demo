package cn.pri.smilly.commonservice.utils;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.exception.ConvertException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public abstract class JsonUtil {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new Jackson2ObjectMapperBuilder().createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
    }

    public static String bean2json(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ConvertException(e);
        }
    }

    public static void main(String[] args) {
        RestResult result = new RestResult(1, "success", null);
        System.out.println(bean2json(result));
    }
}
