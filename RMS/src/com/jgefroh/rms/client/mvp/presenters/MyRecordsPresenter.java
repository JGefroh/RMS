package com.jgefroh.rms.client.mvp.presenters;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.jgefroh.rms.client.mvp.models.BookVO;
import com.jgefroh.rms.client.mvp.models.RecordVO;
import com.jgefroh.rms.client.mvp.views.interfaces.MyRecordsView;
import com.jgefroh.rms.client.mvp.views.interfaces.MyRecordsView.Presenter;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * The presenter for the MyRecords view.
 * @author Joseph Gefroh
 */
public class MyRecordsPresenter implements Presenter {
    
    
    //////////////////////////////////////////////////
    // Logging
    //////////////////////////////////////////////////
    
    private static final Logger LOGGER = Logger.getLogger(MyRecordsPresenter.class.getName());
    private static final LogMessages LOGS = GWT.create(LogMessages.class);
    
    public interface LogMessages extends SafeHtmlTemplates {
    }
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private MyRecordsView view;
    private ClientFactory clientFactory;

    private HandlerRegistration historyHandlerRegistration;
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public MyRecordsPresenter(final ClientFactory clientFactory) {
         this.clientFactory = clientFactory;
         initHistoryHandlers();
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    @Override
    public void bind(MyRecordsView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadRecords() {
        List<RecordVO> records = AppCache.getRecordStore().getRecords(BookVO.Type.BOOK);
        view.showRecords(records);
    }
    

    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////


    
    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////
    
    private void initHistoryHandlers() {
        historyHandlerRegistration = History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(final ValueChangeEvent<String> event) {
                LOGGER.log(Level.INFO, "Intercepting place change: " + event.getValue());
                if (event.getValue().startsWith("editRecord")) {
                    System.out.println("Prepping edit place.");
                }
            }
        });
    }

    @Override
    public void removeAllHandlers() {
        historyHandlerRegistration.removeHandler();
    }
}
