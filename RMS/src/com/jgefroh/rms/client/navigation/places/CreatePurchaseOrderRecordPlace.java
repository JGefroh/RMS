package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CreatePurchaseOrderRecordPlace extends Place {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "createpurchaseorder:";
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public CreatePurchaseOrderRecordPlace() {
    }

    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    public static String getBaseToken() {
        return BASE_TOKEN;
    }
    
    
    //////////////////////////////////////////////////
    // Place Tokenizer
    //////////////////////////////////////////////////
    @Prefix("createpurchaseorder")
    public static class Tokenizer implements PlaceTokenizer<CreatePurchaseOrderRecordPlace> {
        @Override
        public String getToken(final CreatePurchaseOrderRecordPlace place) {
            return "";
        }

        @Override
        public CreatePurchaseOrderRecordPlace getPlace(final String token) {
            return new CreatePurchaseOrderRecordPlace();
        }
    }
}
