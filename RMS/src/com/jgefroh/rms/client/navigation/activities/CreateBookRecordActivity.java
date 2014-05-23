package com.jgefroh.rms.client.navigation.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgefroh.rms.client.mvp.presenters.CreateBookRecordPresenter;
import com.jgefroh.rms.client.mvp.views.interfaces.CreateBookRecordView;
import com.jgefroh.rms.client.mvp.views.interfaces.CreateBookRecordView.Presenter;
import com.jgefroh.rms.client.navigation.places.CreateBookRecordPlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class CreateBookRecordActivity extends AbstractActivity {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private ClientFactory clientFactory;
    private Presenter presenter;
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public CreateBookRecordActivity(final CreateBookRecordPlace place, final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        CreateBookRecordView view = clientFactory.getCreateBookRecordView();
        presenter = new CreateBookRecordPresenter(clientFactory);
        presenter.bind(view);
        
        panel.setWidget(view);
    }
}
