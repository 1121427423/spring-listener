package com.springboot.listener.demo;

import org.springframework.context.ApplicationEvent;

/**
 * @author hspcadmin
 */
public class SpringEvent extends ApplicationEvent {

    public SpringEvent(Object source) {
        super(source);
        System.out.println("SpringEvent");
    }
}
