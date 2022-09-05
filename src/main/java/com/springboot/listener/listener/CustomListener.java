package com.springboot.listener.listener;

import com.springboot.listener.event.CustomEvent;
import org.springframework.stereotype.Component;

/**
 * @author hspcadmin
 */
@Component
public class CustomListener implements BaseListener<CustomEvent>{

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("CustomListener。。。   " + event.getSource().getClass());
    }
}
