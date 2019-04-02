package ru.otus.DI;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.otus.DI.config.AppConfig;
import ru.otus.DI.config.MVCConfig;
import ru.otus.DI.config.SecurityConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MVCConfig.class, SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
