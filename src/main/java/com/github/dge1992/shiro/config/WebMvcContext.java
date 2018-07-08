package com.github.dge1992.shiro.config;


import com.github.dge1992.shiro.filter.SessionInvalidFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web配置类
 */
@Configuration
public class WebMvcContext extends WebMvcConfigurerAdapter {

    /**
     * 配置静态资源访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/hello/**").addResourceLocations("classpath:/hello/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**").excludePathPatterns("/login/login", "/login/toLogin");
        super.addInterceptors(registry);
    }

    /**
     * 配置自定义过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean sessionInvalidFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SessionInvalidFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
