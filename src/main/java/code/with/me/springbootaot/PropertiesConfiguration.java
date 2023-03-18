package code.with.me.springbootaot;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author andong@xiaomalixing.com
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class PropertiesConfiguration {

    @Bean
    ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(DemoProperties properties) {
        return args -> System.out.println("the name is " + properties.name());
    }

}

@ConfigurationProperties(prefix = "code.with.me")
record DemoProperties(String name) {
}
