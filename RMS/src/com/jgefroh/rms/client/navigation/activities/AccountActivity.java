package com.jgefroh.rms.client.navigation.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgefroh.rms.client.mvp.presenters.AccountPresenter;
import com.jgefroh.rms.client.mvp.views.interfaces.AccountView;
import com.jgefroh.rms.client.navigation.places.AccountPlace;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class AccountActivity extends AbstractActivity {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private ClientFactory clientFactory;
    private AccountPresenter presenter;
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public AccountActivity(final AccountPlace place, final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        AccountView view = clientFactory.getAccountView();
        presenter = new AccountPresenter(clientFactory);
        presenter.bind(view);
        
        presenter.mapModelToView(AppCache.getCurrentUser());
        
        panel.setWidget(view);
    }

    @Override
    public void onStop() {
        presenter.resetView();
    }
}
