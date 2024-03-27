package de.trick.connector.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
@ComponentScan("de.trick")
@PropertySource(value = "classpath:environment.properties")
public class MailPreConfig {

    @Resource
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public SendMailConfig sendMailConfig(){
        SendMailConfig config = new SendMailConfig();
        config.setHost(environment.getRequiredProperty("mail.smtp.host"));
        config.setPort(Integer.parseInt(environment.getRequiredProperty("mail.smtp.port")));
        config.setTls(Boolean.valueOf(environment.getRequiredProperty("mail.smtp.starttls.enable")));
        config.setDebug(Boolean.valueOf(environment.getRequiredProperty("mail.smtp.debug")));
        config.setAuth(Boolean.valueOf(environment.getRequiredProperty("mail.smtp.auth")));
        config.setUser(environment.getRequiredProperty("mail.smtp.user"));
        config.setPassword(environment.getRequiredProperty("mail.smtp.password"));
        return config;
    }
}
