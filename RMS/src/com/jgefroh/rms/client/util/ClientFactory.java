package com.jgefroh.rms.client.util;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.jgefroh.rms.client.mvp.views.interfaces.AccountView;
import com.jgefroh.rms.client.mvp.views.interfaces.Code404View;
import com.jgefroh.rms.client.mvp.views.interfaces.CreatePurchaseOrderRecordView;
import com.jgefroh.rms.client.mvp.views.interfaces.LoginView;
import com.jgefroh.rms.client.mvp.views.interfaces.MyRecordsView;
import com.jgefroh.rms.client.mvp.views.interfaces.NavBarView;
import com.jgefroh.rms.client.mvp.views.interfaces.SplashView;

/**
 * @author Joseph Gefroh
 */
public interface ClientFactory {
    PlaceController getPlaceController();
    EventBus getHistoryBus();
    LoginView getLoginView();
    SplashView getSplashView();
    NavBarView getNavBarView();
    AccountView getAccountView();
    Code404View getCode404View();
    MyRecordsView getMyRecordsView();
    CreatePurchaseOrderRecordView getCreatePurchaseOrderRecordView();
}
