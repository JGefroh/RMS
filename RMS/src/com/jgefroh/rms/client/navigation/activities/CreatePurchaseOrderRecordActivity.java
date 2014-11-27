package com.jgefroh.rms.client.navigation.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgefroh.rms.client.mvp.presenters.PurchaseOrderRecordCreatePresenter;
import com.jgefroh.rms.client.mvp.views.interfaces.PurchaseOrderRecordCreateView;
import com.jgefroh.rms.client.mvp.views.interfaces.PurchaseOrderRecordCreateView.Presenter;
import com.jgefroh.rms.client.navigation.places.CreatePurchaseOrderRecordPlace;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class CreatePurchaseOrderRecordActivity extends AbstractActivity {
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////

    private ClientFactory clientFactory;
    private Presenter presenter;
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public CreatePurchaseOrderRecordActivity(final CreatePurchaseOrderRecordPlace place, final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        PurchaseOrderRecordCreateView view = clientFactory.getCreatePurchaseOrderRecordView();
        presenter = new PurchaseOrderRecordCreatePresenter(clientFactory);
        presenter.bind(view);
        
        panel.setWidget(view);
    }
}
