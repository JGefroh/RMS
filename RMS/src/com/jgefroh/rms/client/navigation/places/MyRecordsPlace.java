package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MyRecordsPlace extends Place {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "myrecords:";
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public MyRecordsPlace() {
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
    @Prefix("myrecords")
    public static class Tokenizer implements PlaceTokenizer<MyRecordsPlace> {
        @Override
        public String getToken(final MyRecordsPlace place) {
            return "";
        }

        @Override
        public MyRecordsPlace getPlace(final String token) {
            return new MyRecordsPlace();
        }
    }
}
