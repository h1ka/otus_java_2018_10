package ru.otus.DI.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ru.otus.DI")
//@ComponentScan(basePackages = {"ru.otus.DI.dbservice","ru.otus.DI.model"} )
public class AppConfig {
}
