package com.jgefroh.rms.client.mvp.views.composites;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Joseph Gefroh
 */
public class RecordDropdownMenu extends Composite {
    
    //////////////////////////////////////////////////
    // Boilerplate
    //////////////////////////////////////////////////

    interface UIBinder extends UiBinder<Widget, RecordDropdownMenu> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    private static final Logger LOGGER = Logger.getLogger(RecordDropdownMenu.class.getName());
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    private Integer id;
    @UiField Button btnDelete;
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public RecordDropdownMenu(final Integer id) {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
        this.id = id;
    }

}
