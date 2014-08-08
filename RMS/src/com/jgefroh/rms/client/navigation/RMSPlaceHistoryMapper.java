package com.jgefroh.rms.client.navigation;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.jgefroh.rms.client.navigation.places.AccountPlace;
import com.jgefroh.rms.client.navigation.places.CreatePurchaseOrderRecordPlace;
import com.jgefroh.rms.client.navigation.places.DeletePlace;
import com.jgefroh.rms.client.navigation.places.LoginPlace;
import com.jgefroh.rms.client.navigation.places.MyRecordsPlace;
import com.jgefroh.rms.client.navigation.places.SplashPlace;


@WithTokenizers({
LoginPlace.Tokenizer.class,
SplashPlace.Tokenizer.class,
AccountPlace.Tokenizer.class,
MyRecordsPlace.Tokenizer.class,
CreatePurchaseOrderRecordPlace.Tokenizer.class,
DeletePlace.Tokenizer.class})
public interface RMSPlaceHistoryMapper extends PlaceHistoryMapper {

}
