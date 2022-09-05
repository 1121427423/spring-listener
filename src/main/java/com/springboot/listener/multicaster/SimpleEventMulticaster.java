package com.springboot.listener.multicaster;

import com.springboot.listener.event.BaseEvent;
import com.springboot.listener.listener.BaseListener;
import org.springframework.lang.Nullable;
import java.util.Iterator;
import java.util.concurrent.Executor;

/**
 * @author hspcadmin
 */
public class SimpleEventMulticaster extends AbstractEventMulticaster{

    public SimpleEventMulticaster() {
    }

    @Nullable
    private Executor taskExecutor;

    public void setTaskExecutor(@Nullable Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Nullable
    protected Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    @Override
    public void multicastEvent(BaseEvent event) {
        Executor executor = this.getTaskExecutor();
        Iterator var5 = this.getApplicationListeners(event).iterator();

        while(var5.hasNext()) {
            BaseListener<?> listener = (BaseListener<?>) var5.next();
            if (executor != null) {
                executor.execute(() -> {
                    this.invokeListener(listener, event);
                });
            } else {
                this.invokeListener(listener, event);
            }
        }
    }

    protected void invokeListener(BaseListener<?> listener, BaseEvent event) {
        doInvokeListener(listener, event);
    }

    private void doInvokeListener(BaseListener listener, BaseEvent event) {
        try {
            listener.onApplicationEvent(event);
        } catch (ClassCastException var6) {
            throw new RuntimeException("invokeListener Fail" + listener);
        }
    }
}
