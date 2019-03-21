package com.evyn.springcloud.consumer.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description:
 * @Author xyw
 * @Date 2019/3/3 13:35
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/*", filterName = "hystrixFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext cx = HystrixRequestContext.initializeContext();
        try {
            System.out.println("*******************自定义过滤器**********************");
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cx.shutdown();
        }
    }
}
