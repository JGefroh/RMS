package com.jgefroh.rms.client.mvp.views.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Joseph Gefroh
 */
public class PasswordField extends AbstractField implements HasValue<String>, HasEnabled, HasKeyDownHandlers, HasKeyUpHandlers, HasBlurHandlers {

    //////////////////////////////////////////////////
    // Boilerplate
    //////////////////////////////////////////////////

    interface UIBinder extends UiBinder<Widget, PasswordField> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
     
    @UiField TextBox field;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public PasswordField() {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
    }

    
    //////////////////////////////////////////////////
    // Methods - Event Handlers
    //////////////////////////////////////////////////

    @Override
    public HandlerRegistration addBlurHandler(final BlurHandler handler) {
        return field.addBlurHandler(handler);
    }
    
    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<String> handler) {
        return field.addValueChangeHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyDownHandler(final KeyDownHandler handler) {
        return field.addKeyDownHandler(handler);
    }
    
    @Override
    public HandlerRegistration addKeyUpHandler(final KeyUpHandler handler) {
        return field.addKeyUpHandler(handler);
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Getters
    //////////////////////////////////////////////////
    
    @Override
    public String getValue() {
        return field.getValue();
    }

    public String getValueOrNull() {
        return field.getValue().isEmpty() ? null : field.getValue();
    }
    
    @Override
    public boolean isEnabled() {
        return field.isEnabled();
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Setters
    //////////////////////////////////////////////////
    
    public void setPlaceholder(final String text) {
        field.getElement().setPropertyString("placeholder", text);
    }
    
    @Override
    public void setValue(final String value) {
        field.setValue(value);
    }

    @Override
    public void setValue(final String value, final boolean fireEvents) {
        field.setValue(value, fireEvents);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        field.setEnabled(enabled);
    }
}
