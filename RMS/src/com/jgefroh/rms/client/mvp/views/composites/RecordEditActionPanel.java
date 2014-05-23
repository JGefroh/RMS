package com.jgefroh.rms.client.mvp.views.composites;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.jgefroh.rms.client.events.ActionRequested;
import com.jgefroh.rms.client.events.ActionRequestedHandler;

/**
 * @author Joseph Gefroh
 */
public class RecordEditActionPanel extends Composite {
    
    interface RecordEditActionPanelUiBinder extends UiBinder<Widget, RecordEditActionPanel> {}
    private static RecordEditActionPanelUiBinder uiBinder = GWT.create(RecordEditActionPanelUiBinder.class);
    
    public enum Action implements ActionRequested.Action {
        SAVE,
        EXAMINE,
        SUBMIT
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    
    @UiField Button btnSave;
    @UiField Button btnExamine;
    @UiField Button btnSubmit;

    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private EventBus eventBus;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public RecordEditActionPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        eventBus = new SimpleEventBus();
    }
    

    //////////////////////////////////////////////////
    // Methods - Wiring
    //////////////////////////////////////////////////
    
    /**
     * Adds a handler to respond to this widget's action requests.
     * @param handler   the handler to add
     * @return  the handler registration used to register the handler
     */
    public HandlerRegistration addActionRequestedHandler(final ActionRequestedHandler handler) {
        return eventBus.addHandler(ActionRequested.TYPE, handler);
    }
    
    
    //////////////////////////////////////////////////
    // UI Event Handlers
    //////////////////////////////////////////////////
    
    @UiHandler({"btnSave", "btnExamine", "btnSubmit"})
    void onButtonClicked(final ClickEvent event) {
        Object source = event.getSource();
        Action action = null;
        if (source == btnSave) {
            action = Action.SAVE;
        }
        else if (source == btnExamine) {
            action = Action.EXAMINE;
        }
        else if (source == btnSubmit) {
            action = Action.SUBMIT;
        }
        eventBus.fireEvent(new ActionRequested(action));
    }
}
