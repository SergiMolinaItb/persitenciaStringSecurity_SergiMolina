package cat.itb.projecte.configuracio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracioVistes implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry reg) {
        reg.addViewController("/").setViewName("index.html");
        reg.addViewController("/login").setViewName("login.html");
        reg.addViewController("/errorlogin").setViewName("errorlogin.html");
        reg.addViewController("/error").setViewName("error.html");
        reg.addViewController("/home").setViewName("info.html");
        reg.addViewController("/new").setViewName("afegir.html");
        reg.addViewController("/register").setViewName("register.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }
}
