package code.with.me.springbootaot;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
/**
 * @author andong@xiaomalixing.com
 */

@Configuration
public class EventsConfiguration {
    @Bean
    ApplicationListener<WebServerInitializedEvent> webServerInitializedEventApplicationListener() {
        return event -> run("ApplicationListener<WebServerInitializedEvent>", event);
    }

    @EventListener
    public void onApplicationEvent(ApplicationEvent event) {
        run("@EventListener", event);
    }

    private void run(String where, ApplicationEvent are) {
        System.out.println(where + " : " + are);
    }
}
