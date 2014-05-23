package com.jgefroh.rms.client.events;

import com.google.gwt.event.shared.GwtEvent;


/**
 * Fired when the user has logged in successfully.
 * @author Joseph Gefroh
 */
public class LoginSucceeded extends GwtEvent<LoginSucceededHandler> {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    public static Type<LoginSucceededHandler> TYPE = new Type<LoginSucceededHandler>();


    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    public LoginSucceeded() {
    }
    

    //////////////////////////////////////////////////
    // Methods - Overrides
    //////////////////////////////////////////////////

    @Override
    public Type<LoginSucceededHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final LoginSucceededHandler handler) {
        handler.handle(this);
    }
}