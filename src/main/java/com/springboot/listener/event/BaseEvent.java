package com.springboot.listener.event;

import java.util.EventObject;

/**
 * @author hspcadmin
 */
public abstract class BaseEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public BaseEvent(Object source) {
        super(source);
    }
}
