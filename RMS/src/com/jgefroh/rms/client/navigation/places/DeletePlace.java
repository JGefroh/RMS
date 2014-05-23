package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class DeletePlace extends Place {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "delete:";
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public DeletePlace() {
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
    
    @Prefix("deleteRecord")
    public static class Tokenizer implements PlaceTokenizer<DeletePlace> {
        @Override
        public String getToken(final DeletePlace place) {
            return "";
        }

        @Override
        public DeletePlace getPlace(final String token) {
            return new DeletePlace();
        }
    }
}
