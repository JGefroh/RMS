/**
 * 
 */
package com.jgefroh.rms.client.mvp.views.impls;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.views.interfaces.NavBarView;
import com.jgefroh.rms.client.navigation.places.AccountPlace;
import com.jgefroh.rms.client.navigation.places.MyRecordsPlace;
import com.jgefroh.rms.client.navigation.places.SplashPlace;


/**
 * @author Joseph Gefroh
 */
public class NavBarViewImpl extends Composite implements NavBarView {


    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    interface NavBarViewImplUiBinder extends UiBinder<Widget, NavBarViewImpl> {}
    private static NavBarViewImplUiBinder uiBinder = GWT.create(NavBarViewImplUiBinder.class);
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    @UiField AnchorElement home;
    @UiField AnchorElement account;
    @UiField AnchorElement help;
    @UiField AnchorElement myRecords;
    
    @UiField LIElement homePill;
    @UiField LIElement accountPill;
    @UiField LIElement myRecordsPill;
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Presenter presenter;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public NavBarViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        account.setHref("index.html#account:");
        home.setHref("index.html#splash:");
        myRecords.setHref("index.html#myrecords:");
    }


    //////////////////////////////////////////////////
    // Methods - Event Handlers
    //////////////////////////////////////////////////
    
    //////////////////////////////////////////////////
    // Methods - Interface Overrides
    //////////////////////////////////////////////////
    
    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setActiveLink(final String baseToken) {
        clearActiveLinks();
        if (baseToken.startsWith(SplashPlace.getBaseToken())) {
            homePill.addClassName("active");
        }
        else if (baseToken.startsWith(AccountPlace.getBaseToken())) {
            accountPill.addClassName("active");
        }
        else if (baseToken.startsWith(MyRecordsPlace.getBaseToken())) {
            myRecordsPill.addClassName("active");
        }
    }
    
    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////
    
    private void clearActiveLinks() {
        homePill.removeClassName("active");
        accountPill.removeClassName("active");
        myRecordsPill.removeClassName("active");
    }
    
    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////
}
