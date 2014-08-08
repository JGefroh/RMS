package com.jgefroh.rms.client.mvp.presenters;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.jgefroh.rms.client.mvp.views.interfaces.CreatePurchaseOrderRecordView;
import com.jgefroh.rms.client.mvp.views.interfaces.CreatePurchaseOrderRecordView.Presenter;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * The presenter for the CreatePurchaseOrderRecord view.
 * @author Joseph Gefroh
 */
public class CreatePurchaseOrderRecordPresenter implements Presenter {
    
    
    //////////////////////////////////////////////////
    // Logging
    //////////////////////////////////////////////////
    
    private static final Logger LOGGER = Logger.getLogger(CreatePurchaseOrderRecordPresenter.class.getName());
    private static final LogMessages LOGS = GWT.create(LogMessages.class);
    
    public interface LogMessages extends SafeHtmlTemplates {
    }
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private CreatePurchaseOrderRecordView view;
    private ClientFactory clientFactory;

    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public CreatePurchaseOrderRecordPresenter(final ClientFactory clientFactory) {
         this.clientFactory = clientFactory;
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    @Override
    public void bind(CreatePurchaseOrderRecordView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void onSaveRequested() {
    }

    @Override
    public void onExamineRequested() {
        LOGGER.log(Level.INFO, "EXAMINE REQUESTED");
    }

    @Override
    public void onSubmitRequested() {
        LOGGER.log(Level.INFO, "SUBMIT REQUESTED");
    }
    

    //////////////////////////////////////////////////
    // Methods - Actions
    //////////////////////////////////////////////////

    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////


}
