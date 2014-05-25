package com.jgefroh.rms.client.mvp.views.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil;


/**
 * @author Joseph Gefroh
 */
public class DismissableAlert extends Composite {
    //////////////////////////////////////////////////
    // Boilerplate
    //////////////////////////////////////////////////

    interface UIBinder extends UiBinder<Widget, DismissableAlert> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    
    @UiField SpanElement text;
    @UiField SpanElement lead;
    
     
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public DismissableAlert() {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
    }


    //////////////////////////////////////////////////
    // Methods - Events
    //////////////////////////////////////////////////
    
    @UiHandler("btnClose")
    void closeAlert(final ClickEvent event) {
        hide();
    }
    
    //////////////////////////////////////////////////
    // Methods - Setters
    //////////////////////////////////////////////////
    
    public void setText(final String value) {
        text.setInnerText(value);
    }
    
    public void setLead(final String value) {
        lead.setInnerText(value);
    }

    public void show() {
        BootstrapUtil.show(this.asWidget().getElement());
    }
    
    public void hide() {
        BootstrapUtil.hide(this.asWidget().getElement());
    }
    
}