package com.springboot.listener.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springboot.listener.demo")
public class SpringListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringListenerDemo.class);
        context.publishEvent(new SpringEvent("Test Listener"));
    }
}
