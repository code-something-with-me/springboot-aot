package code.with.me.springbootaot;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

interface Animal {
    void speak();
}

/**
 * @author andong@xiaomalixing.com
 */
@Configuration
public class FactoryBeansConfiguration {

    @Bean
    FactoryBean<Animal> animalFactoryBean() {
        return new AnimalFactoryFactory(true, false);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> factoryBeansApplicationListener(Animal animal) {
        return event -> animal.speak();
    }

}

class AnimalFactoryFactory implements FactoryBean<Animal> {
    private final boolean likesYarn, likesFrisbees;

    public AnimalFactoryFactory(boolean likesYarn, boolean likesFrisbees) {
        this.likesYarn = likesYarn;
        this.likesFrisbees = likesFrisbees;
    }

    @Override
    public Animal getObject() throws Exception {
        return (likesYarn && !likesFrisbees) ? new Cat() : new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}

class Dog implements Animal {

    @Override
    public void speak() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {

    @Override
    public void speak() {
        System.out.println("Meow");
    }
}