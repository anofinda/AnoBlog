package pers.anofinda.anoblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dongyudeng
 */
@SpringBootApplication
public class AnoBlogApplication {

    @Bean
    WebMvcConfigurer createWebMvcConfigurer(@Autowired(required = false) HandlerInterceptor[] interceptors) {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 添加拦截器
                if (interceptors != null) {
                    for (var interceptor : interceptors) {
                        registry.addInterceptor(interceptor);
                    }
                }
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // 映射路径`/static/`到classpath路径:
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/static/");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AnoBlogApplication.class, args);
    }
}
