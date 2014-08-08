package com.jgefroh.rms.client.util;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.jgefroh.rms.client.mvp.views.impls.AccountViewImpl;
import com.jgefroh.rms.client.mvp.views.impls.Code404ViewImpl;
import com.jgefroh.rms.client.mvp.views.impls.CreatePurchaseOrderRecordViewImpl;
import com.jgefroh.rms.client.mvp.views.impls.LoginViewImpl;
import com.jgefroh.rms.client.mvp.views.impls.MyRecordsViewImpl;
import com.jgefroh.rms.client.mvp.views.impls.NavBarViewImpl;
import com.jgefroh.rms.client.mvp.views.impls.SplashViewImpl;
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
public class ClientFactoryImpl implements ClientFactory {

    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static EventBus historyBus;
    private static LoginView loginView;
    private static SplashView splashView;
    private static NavBarView navBarView;
    private static AccountView accountView;
    private static Code404View code404View;
    private static MyRecordsView myRecordsView;
    private static CreatePurchaseOrderRecordView createPurchaseOrderRecordView;
    private static PlaceController placeController;
    
    //////////////////////////////////////////////////
    // Methods - Getters
    //////////////////////////////////////////////////

    @Override
    public EventBus getHistoryBus() {
        if (historyBus == null) {
            historyBus = new SimpleEventBus();
        }
        return historyBus;
    }

    @Override
    public PlaceController getPlaceController() {
        if (placeController == null) {
            placeController = new PlaceController(getHistoryBus());
        }
        return placeController;
    }

    @Override
    public LoginView getLoginView() {
        if (loginView == null) {
            loginView = new LoginViewImpl();
        }
        return loginView;
    }

    @Override
    public SplashView getSplashView() {
        if (splashView == null) {
            splashView = new SplashViewImpl();
        }
        return splashView;
    }

    @Override
    public NavBarView getNavBarView() {
        if (navBarView == null) {
            navBarView = new NavBarViewImpl();
        }
        return navBarView;
    }
    
    @Override
    public AccountView getAccountView() {
        if (accountView == null) {
            accountView = new AccountViewImpl();
        }
        return accountView;
    }

    @Override
    public Code404View getCode404View() {
        if (code404View == null) {
            code404View = new Code404ViewImpl();
        }
        return code404View;
    }

    @Override
    public MyRecordsView getMyRecordsView() {
        if (myRecordsView == null) {
            myRecordsView = new MyRecordsViewImpl();
        }
        return myRecordsView;
    }
    
    @Override
    public CreatePurchaseOrderRecordView getCreatePurchaseOrderRecordView() {
        if (createPurchaseOrderRecordView == null) {
            createPurchaseOrderRecordView = new CreatePurchaseOrderRecordViewImpl();
        }
        return createPurchaseOrderRecordView;
    }
    
}
