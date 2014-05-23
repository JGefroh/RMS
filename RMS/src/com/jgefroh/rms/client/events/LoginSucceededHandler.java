package com.jgefroh.rms.client.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * The event handler for the event with the same name.
 * @author Joseph Gefroh
 */
public interface LoginSucceededHandler extends EventHandler {
    void handle(LoginSucceeded event);
}