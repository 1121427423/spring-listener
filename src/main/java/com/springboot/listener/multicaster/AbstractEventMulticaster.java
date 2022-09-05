package com.springboot.listener.multicaster;

import com.springboot.listener.event.BaseEvent;
import com.springboot.listener.listener.BaseListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/**
 * @author hspcadmin
 */
public abstract class AbstractEventMulticaster implements BaseEventMulticaster{

    public AbstractEventMulticaster() {
    }

    public final Set<BaseListener<?>> applicationListeners = new LinkedHashSet();

    @Override
    public void addApplicationListener(BaseListener<?> listener) {
        this.applicationListeners.add(listener);
    }

    @Override
    public void removeApplicationListener(BaseListener<?> listener) {
        this.applicationListeners.remove(listener);
    }

    protected Collection<BaseListener<?>> getApplicationListeners(BaseEvent event) {
        return this.applicationListeners;
    }

}
