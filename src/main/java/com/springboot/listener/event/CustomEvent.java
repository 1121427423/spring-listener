package com.springboot.listener.event;

public class CustomEvent extends BaseEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source) {
        super(source);
            System.out.println("CustomEvent");
    }
}
