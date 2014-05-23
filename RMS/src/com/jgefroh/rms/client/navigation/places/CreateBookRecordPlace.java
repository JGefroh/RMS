package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class CreateBookRecordPlace extends Place {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "createbookrecord:";
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public CreateBookRecordPlace() {
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
    @Prefix("createbookrecord")
    public static class Tokenizer implements PlaceTokenizer<CreateBookRecordPlace> {
        @Override
        public String getToken(final CreateBookRecordPlace place) {
            return "";
        }

        @Override
        public CreateBookRecordPlace getPlace(final String token) {
            return new CreateBookRecordPlace();
        }
    }
}
