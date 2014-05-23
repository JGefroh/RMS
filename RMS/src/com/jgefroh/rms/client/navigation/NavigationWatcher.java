package com.jgefroh.rms.client.navigation;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.History;
import com.jgefroh.rms.client.mvp.presenters.LoginPresenter;
import com.jgefroh.rms.client.navigation.places.SplashPlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * Handles events that occur on navigation.
 * @author Joseph Gefroh
 */
public class NavigationWatcher {

    //////////////////////////////////////////////////
    // Logging
    //////////////////////////////////////////////////
    
    private static final Logger LOGGER = Logger.getLogger(NavigationWatcher.class.getName());
    private static final LogMessages LOGS = GWT.create(LogMessages.class);
    
    public interface LogMessages extends SafeHtmlTemplates {
        @Template("Changing active link to: {0}")
        SafeHtml activeLink(String link);
    }    
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private ClientFactory clientFactory;
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public NavigationWatcher(final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        addNavigationLinkChangeHandler();
    }

    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    private void addNavigationLinkChangeHandler() {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(final ValueChangeEvent<String> event) {
                changeActiveLink(event.getValue());
            }
        });
    }
    
    private void changeActiveLink(final String link) {
        LOGGER.log(Level.INFO, LOGS.activeLink(link).asString());
        clientFactory.getNavBarView().setActiveLink(link);
    }
    
}
