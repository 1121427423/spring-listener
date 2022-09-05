package com.springboot.listener.multicaster;

import com.springboot.listener.event.BaseEvent;
import com.springboot.listener.listener.BaseListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public interface BaseEventMulticaster {

    void addApplicationListener(BaseListener<?> listener);

    void removeApplicationListener(BaseListener<?> listener);

    void multicastEvent(BaseEvent event);

}
