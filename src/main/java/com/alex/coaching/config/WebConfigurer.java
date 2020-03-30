package com.alex.coaching.config;

import com.alex.coaching.common.Constants;
import com.alex.coaching.config.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 在yml的配置文件一样也可以配置 spring.mvc.static-path-pattern: 匹配的访问路径（静态资源路径匹配规则）
        //  spring.resources.static-locations: 具体上哪找这些静态资源

        ////配置静态资源访问匹配路径及上哪找这些资源（自定义路径匹配规则及资源位置）
      /* registry.addResourceHandler("/**")
               .addResourceLocations("classpath:/static/");*/
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns(
                        "/login",
                        "/register",
                        "/index.html",
                        "/layuiadmin/**"
                        );


    }
}
