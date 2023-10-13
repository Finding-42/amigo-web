package com.edwardjones.cf23.sidekick;

import com.google.common.base.Strings;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import javax.sql.DataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@Push
@Theme(value = "codefest23")
@JsModule("@vaadin/vaadin-lumo-styles/presets/compact.js")
@PWA(name = "Codefest23", shortName = "Codefest23")
@SpringBootApplication
public class Codefest23Application implements AppShellConfigurator
{
    @Autowired
    private Environment environment;
    
    public static void main(String[] args)
    {
        SpringApplication.run(Codefest23Application.class, args);
    }
    
    @Bean
    @Primary
    @ConfigurationProperties("main.datasource")
    DataSourceProperties dataSourceProperties()
    {
        return new DataSourceProperties();
    }
    
    @Bean
    @Primary
    @ConfigurationProperties("main.datasource.hikari")
    DataSource dataSource(final DataSourceProperties dataSourceProperties)
    {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    
    @EventListener
    public void printApplicationUrl(final ApplicationStartedEvent event)
    {
        LoggerFactory.getLogger(Codefest23Application.class).info("Application started at "
                                                                      + "http://localhost:"
                                                                      + environment.getProperty("local.server.port")
                                                                      + Strings.nullToEmpty(
            environment.getProperty("server.servlet.context-path")));
    }
}
