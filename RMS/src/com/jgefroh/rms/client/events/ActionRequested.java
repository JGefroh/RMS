package com.jgefroh.rms.client.events;

import com.google.gwt.event.shared.GwtEvent;


/**
 * Fired when the user has logged in successfully.
 * @author Joseph Gefroh
 */
public class ActionRequested extends GwtEvent<ActionRequestedHandler> {

    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    public interface Action {
    }
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    public static Type<ActionRequestedHandler> TYPE = new Type<ActionRequestedHandler>();
    private Action action;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public ActionRequested(final Action action) {
        this.action = action;
    }
    

    //////////////////////////////////////////////////
    // Methods - Getters
    //////////////////////////////////////////////////
    
    public Action getAction() {
        return this.action;
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Overrides
    //////////////////////////////////////////////////

    @Override
    public Type<ActionRequestedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final ActionRequestedHandler handler) {
        handler.handle(this);
    }
}