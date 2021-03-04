package kz.sitedev.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "kz.sitedev.jpa")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.sitedev.jpa.repository")
public class Config {}
