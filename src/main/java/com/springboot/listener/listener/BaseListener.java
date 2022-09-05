package com.springboot.listener.listener;

import com.springboot.listener.event.BaseEvent;
import java.util.EventListener;

/**
 * @author hspcadmin
 */
public interface BaseListener<E extends BaseEvent> extends EventListener {

    void onApplicationEvent(E event);
}
