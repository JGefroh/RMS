package com.jgefroh.rms.client.navigation;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.jgefroh.rms.client.navigation.activities.AccountActivity;
import com.jgefroh.rms.client.navigation.activities.Code404Activity;
import com.jgefroh.rms.client.navigation.activities.CreatePurchaseOrderRecordActivity;
import com.jgefroh.rms.client.navigation.activities.LoginActivity;
import com.jgefroh.rms.client.navigation.activities.MyRecordsActivity;
import com.jgefroh.rms.client.navigation.activities.SplashActivity;
import com.jgefroh.rms.client.navigation.places.AccountPlace;
import com.jgefroh.rms.client.navigation.places.Code404Place;
import com.jgefroh.rms.client.navigation.places.CreatePurchaseOrderRecordPlace;
import com.jgefroh.rms.client.navigation.places.LoginPlace;
import com.jgefroh.rms.client.navigation.places.MyRecordsPlace;
import com.jgefroh.rms.client.navigation.places.SplashPlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class RMSActivityMapper implements ActivityMapper {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    private ClientFactory clientFactory;

    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    public RMSActivityMapper(final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public Activity getActivity(final Place place) {
        if (place instanceof SplashPlace) {
            return new SplashActivity((SplashPlace) place, clientFactory);
        }
        else if (place instanceof AccountPlace) {
            return new AccountActivity((AccountPlace) place, clientFactory);
        }
        else if (place instanceof LoginPlace) {
            return new LoginActivity((LoginPlace) place, clientFactory);
        }
        else if (place instanceof MyRecordsPlace) {
            return new MyRecordsActivity((MyRecordsPlace) place, clientFactory);
        }
        else if (place instanceof CreatePurchaseOrderRecordPlace) {
            return new CreatePurchaseOrderRecordActivity((CreatePurchaseOrderRecordPlace) place, clientFactory);
        }
        else if (place instanceof Code404Place) {
            return new Code404Activity((Code404Place) place, clientFactory);
        }
        return null;
    }
    
}
