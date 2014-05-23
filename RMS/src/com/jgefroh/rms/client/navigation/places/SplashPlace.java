package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SplashPlace extends Place {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "splash:";
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public SplashPlace() {
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
    @Prefix("splash")
    public static class Tokenizer implements PlaceTokenizer<SplashPlace> {
        @Override
        public String getToken(final SplashPlace place) {
            return "";
        }

        @Override
        public SplashPlace getPlace(final String token) {
            return new SplashPlace();
        }
    }
}
