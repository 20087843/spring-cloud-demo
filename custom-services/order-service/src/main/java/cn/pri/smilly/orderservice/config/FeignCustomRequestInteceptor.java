package cn.pri.smilly.orderservice.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
public class FeignCustomRequestInteceptor implements RequestInterceptor {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate template) {
        if (HttpMethod.GET.toString() == template.method() && template.body() != null) {
            //feign 不支持GET方法传输POJO 转换成json，再换成query
            try {
                TypeReference<Map<String, Collection<String>>> typeReference = new TypeReference() {
                };
                Map<String, Collection<String>> map = objectMapper.readValue(template.bodyTemplate(), typeReference);
                template.body((Request.Body) null);
                template.queries(map);
            } catch (IOException e) {
                log.error("cause exception", e);
            }
        }
    }


}
