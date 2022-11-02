package codegym.vn.muonsach.config;


import codegym.vn.muonsach.formatter.DateFomatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAspectJAutoProxy
public class Config implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFomatter());
//        registry.addConverter(new DateConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        // Register resource handler for images
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("/static/");

    }



}
