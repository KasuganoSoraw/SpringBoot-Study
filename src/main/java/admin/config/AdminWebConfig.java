package admin.config;

import admin.interceptor.LoginInterceptor;
import admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author WPZ
 * @Date 2022/5/3 11:41
 * @Version 1.0
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/", "/login", "/city");

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns("/", "/login", "/city");
    }
}
