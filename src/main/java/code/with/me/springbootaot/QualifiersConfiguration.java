package code.with.me.springbootaot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier("ios")
@interface Apple {

}

@Retention(RetentionPolicy.RUNTIME)
@Qualifier("android")
@interface Android {
}


interface MobileMarketplace {
}

@Service
@Qualifier("ios")
class AppStore implements MobileMarketplace {
}

@Service
@Qualifier("android")
class PlayStore implements MobileMarketplace {
}


/**
 * @author andong@xiaomalixing.com
 */
@Configuration
public class QualifiersConfiguration {

    @Bean
    ApplicationListener<ApplicationReadyEvent> android(@Android MobileMarketplace mobileMarketplace) {
        return event -> System.out.println(mobileMarketplace.getClass().toString());
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> ios(@Apple MobileMarketplace mobileMarketplace) {
        return event -> System.out.println(mobileMarketplace.getClass().toString());
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> mobileMarketplaceListener(
            Map<String, MobileMarketplace> mobileMarketplaces) {
        return event -> mobileMarketplaces
                .forEach((key, bean) -> System.out.println(key + '=' + bean.getClass().
                        getName()));
    }

}