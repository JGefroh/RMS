package com.jgefroh.rms.client.mvp.views.widgets;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Joseph Gefroh
 */
public class BasicPanel extends Composite implements HasWidgets {
    
    //////////////////////////////////////////////////
    // Boilerplate
    //////////////////////////////////////////////////

    interface UIBinder extends UiBinder<Widget, BasicPanel> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
     
    @UiField FlowPanel content;
    @UiField HeadingElement headingText;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public BasicPanel() {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
    }

    
    //////////////////////////////////////////////////
    // Methods - Setters
    //////////////////////////////////////////////////
    
    public void setHeading(final String text) {
        headingText.setInnerText(text);
    }
    
    
    //////////////////////////////////////////////////
    // Methods - HasWidgets
    //////////////////////////////////////////////////

    @Override
    public void add(final Widget widget) {
        content.add(widget);
    }

    @Override
    public void clear() {
        content.clear();
    }

    @Override
    public Iterator<Widget> iterator() {
        return content.iterator();
    }

    @Override
    public boolean remove(final Widget widget) {
        return content.remove(widget);
    }
}
