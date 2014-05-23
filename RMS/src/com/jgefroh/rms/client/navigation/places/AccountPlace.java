package com.jgefroh.rms.client.navigation.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AccountPlace extends Place {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final String BASE_TOKEN = "account:";
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public AccountPlace() {
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
    @Prefix("account")
    public static class Tokenizer implements PlaceTokenizer<AccountPlace> {
        @Override
        public String getToken(final AccountPlace place) {
            return "";
        }

        @Override
        public AccountPlace getPlace(final String token) {
            return new AccountPlace();
        }
    }
}
