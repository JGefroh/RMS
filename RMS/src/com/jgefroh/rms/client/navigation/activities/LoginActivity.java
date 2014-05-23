package com.jgefroh.rms.client.navigation.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgefroh.rms.client.mvp.presenters.LoginPresenter;
import com.jgefroh.rms.client.mvp.views.interfaces.LoginView;
import com.jgefroh.rms.client.navigation.places.LoginPlace;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class LoginActivity extends AbstractActivity {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private ClientFactory clientFactory;
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public LoginActivity(final LoginPlace place, final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        if (AppCache.getCurrentUser() == null) {
            LoginView view = clientFactory.getLoginView();
            LoginPresenter presenter = new LoginPresenter(clientFactory);
            presenter.bind(view);
            panel.setWidget(clientFactory.getLoginView());
        }
        else {
            onCancel();
        }
    }

}
