package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class Code404Place extends Place {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "404:";
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public Code404Place() {
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
    @Prefix("404")
    public static class Tokenizer implements PlaceTokenizer<Code404Place> {
        @Override
        public String getToken(final Code404Place place) {
            return "";
        }

        @Override
        public Code404Place getPlace(final String token) {
            return new Code404Place();
        }
    }
}
