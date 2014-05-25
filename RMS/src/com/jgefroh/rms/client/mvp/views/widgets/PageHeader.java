package com.jgefroh.rms.client.mvp.views.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Joseph Gefroh
 */
public class PageHeader extends Composite {
    
    //////////////////////////////////////////////////
    // Boilerplate
    //////////////////////////////////////////////////

    interface UIBinder extends UiBinder<Widget, PageHeader> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    
    @UiField SpanElement header;
    @UiField SpanElement description;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public PageHeader() {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
    }

    
    //////////////////////////////////////////////////
    // Methods - Setters
    //////////////////////////////////////////////////
    
    public void setHeader(final String text) {
        header.setInnerText(text);
    }
    
    public void setDescription(final String text) {
        description.setInnerText(text);
    }
}
