package com.jgefroh.rms.client.navigation;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.DialogBox;
import com.jgefroh.rms.client.navigation.places.DeletePlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class RMSPopupActivityMapper implements ActivityMapper {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    private ClientFactory clientFactory;

    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    public RMSPopupActivityMapper(final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public Activity getActivity(final Place place) {
        if (place instanceof DeletePlace) {
            System.out.println("DELETING");
            GWT.log("DELETING");
            new DialogBox().show();
        }
        return null;
    }
    
}
