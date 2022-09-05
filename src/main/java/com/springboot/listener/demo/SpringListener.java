package com.springboot.listener.demo;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author hspcadmin
 */
@Component
public class SpringListener implements ApplicationListener<SpringEvent> {
    @Override
    public void onApplicationEvent(SpringEvent event) {
        System.out.println("SpringListener。。。" + event.getSource().getClass());
    }
}
