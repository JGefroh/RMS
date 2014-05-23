package com.jgefroh.rms.client.navigation.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgefroh.rms.client.navigation.places.SplashPlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class SplashActivity extends AbstractActivity {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private ClientFactory clientFactory;
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public SplashActivity(final SplashPlace place, final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        panel.setWidget(clientFactory.getSplashView());
    }

}
