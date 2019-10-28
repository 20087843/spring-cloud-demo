package cn.pri.smilly.zuulservice.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenVerifyFilter extends ZuulFilter {
    /**
     * 过滤器类型选择：
     * pre 为路由前
     * route 为路由过程中
     * post 为路由过程后
     * error 为出现错误的时候
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 用来过滤器排序执行的
     *
     * @return 排序的序号
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否通过这个过滤器，默认为true，改成false则不启用
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
