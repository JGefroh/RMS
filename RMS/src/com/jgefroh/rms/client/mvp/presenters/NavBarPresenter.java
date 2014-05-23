package com.jgefroh.rms.client.mvp.presenters;


import java.util.logging.Logger;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.place.shared.Place;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiField;
import com.jgefroh.rms.client.mvp.views.interfaces.NavBarView;
import com.jgefroh.rms.client.mvp.views.interfaces.NavBarView.Presenter;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * The presenter for the login view.
 * @author Joseph Gefroh
 */
public class NavBarPresenter implements Presenter {
    
    
    //////////////////////////////////////////////////
    // Logging
    //////////////////////////////////////////////////
    
    private static final Logger LOGGER = Logger.getLogger(NavBarPresenter.class.getName());
    private static final LogMessages LOGS = GWT.create(LogMessages.class);
    
    public interface LogMessages extends SafeHtmlTemplates {
        @Template("Menu item clicked: {0}.")
        SafeHtml menuItemClicked(String menuItem);
    }
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private NavBarView view;
    
    
    private ClientFactory clientFactory;

    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public NavBarPresenter(final ClientFactory clientFactory) {
         this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    @Override
    public void bind(final NavBarView view) {
        this.view = view;
        this.view.setPresenter(this);
    }
    

    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////

    
    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////

}
