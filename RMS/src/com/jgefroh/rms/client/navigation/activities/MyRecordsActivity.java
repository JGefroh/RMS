package com.jgefroh.rms.client.navigation.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgefroh.rms.client.mvp.presenters.MyRecordsPresenter;
import com.jgefroh.rms.client.mvp.views.interfaces.MyRecordsView;
import com.jgefroh.rms.client.mvp.views.interfaces.MyRecordsView.Presenter;
import com.jgefroh.rms.client.navigation.places.MyRecordsPlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class MyRecordsActivity extends AbstractActivity {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private ClientFactory clientFactory;
    private Presenter presenter;
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public MyRecordsActivity(final MyRecordsPlace place, final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        MyRecordsView view = clientFactory.getMyRecordsView();
        presenter = new MyRecordsPresenter(clientFactory);
        presenter.bind(view);
        presenter.loadRecords();
        panel.setWidget(view);
    }

    @Override
    public void onStop() {
        presenter.removeAllHandlers();
    }
}
