package cn.pri.smilly.zuulservice.exception;

import cn.pri.smilly.commonservice.bean.RestResult;
import cn.pri.smilly.commonservice.constant.RestStatus;
import cn.pri.smilly.commonservice.utils.ConvertUtil;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ServiceFallbackProviderImpl implements FallbackProvider {
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_GATEWAY;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }

            @Override
            public InputStream getBody() throws IOException {
                RestResult result = RestResult.fail(RestStatus.SVRERR, "微服务不可用，请稍后再试");
                String content = ConvertUtil.bean2json(result);
                return new ByteArrayInputStream(content.getBytes());
            }

            @Override
            public void close() {

            }
        };
    }

    @Override
    public String getRoute() {
        return "*";
    }
}
