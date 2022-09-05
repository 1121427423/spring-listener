package com.springboot.listener.context;

import com.springboot.listener.event.BaseEvent;
import com.springboot.listener.event.CustomEvent;
import com.springboot.listener.listener.CustomListener;
import com.springboot.listener.multicaster.BaseEventMulticaster;
import com.springboot.listener.multicaster.SimpleEventMulticaster;
import org.springframework.lang.Nullable;

/**
 * @author hspcadmin
 */
public class SpringListenerContext {

    public static void main(String[] args) {
        //new CustomEvent(beanFactory)
        new SpringListenerContext().publishEvent(new CustomEvent("Test Listener"));
    }

    public SpringListenerContext() {
        this.refresh();
    }

    @Nullable
    private BaseEventMulticaster applicationEventMulticaster;

    public void refresh() {
        initEventMulticaster();
        registerListeners();
    }

    private void initEventMulticaster() {
       this.applicationEventMulticaster = new SimpleEventMulticaster();
    }

    BaseEventMulticaster getBaseEventMulticaster() throws IllegalStateException {
        if (this.applicationEventMulticaster == null) {
            throw new IllegalStateException("ApplicationEventMulticaster not initialized - call 'refresh' before multicasting events via the context: " + this);
        } else {
            return this.applicationEventMulticaster;
        }
    }

    private void registerListeners() {
        this.getBaseEventMulticaster().addApplicationListener(new CustomListener());
    }

    public void publishEvent(BaseEvent event) {
        this.applicationEventMulticaster.multicastEvent(event);
    }


}
