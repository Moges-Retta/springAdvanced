package be.vdab.meertatalige;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final int ZEVEN_DAGEN = 604_800;
    @Bean
    LocaleResolver localeResolver() {
        //return new FixedLocaleResolver(new Locale("en", "US"));
       // return new SessionLocaleResolver();
        var resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(ZEVEN_DAGEN);
        return resolver;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }
}
