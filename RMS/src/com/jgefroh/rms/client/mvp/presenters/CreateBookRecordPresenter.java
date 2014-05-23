package com.jgefroh.rms.client.mvp.presenters;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.user.client.History;
import com.jgefroh.rms.client.mvp.models.BookVO;
import com.jgefroh.rms.client.mvp.models.RecordVO;
import com.jgefroh.rms.client.mvp.views.constants.ValidationState;
import com.jgefroh.rms.client.mvp.views.interfaces.CreateBookRecordView;
import com.jgefroh.rms.client.mvp.views.interfaces.CreateBookRecordView.Presenter;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * The presenter for the CreateBookRecord view.
 * @author Joseph Gefroh
 */
public class CreateBookRecordPresenter implements Presenter {
    
    
    //////////////////////////////////////////////////
    // Logging
    //////////////////////////////////////////////////
    
    private static final Logger LOGGER = Logger.getLogger(CreateBookRecordPresenter.class.getName());
    private static final LogMessages LOGS = GWT.create(LogMessages.class);
    
    public interface LogMessages extends SafeHtmlTemplates {
    }
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private CreateBookRecordView view;
    private ClientFactory clientFactory;

    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public CreateBookRecordPresenter(final ClientFactory clientFactory) {
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
    public void bind(CreateBookRecordView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void onSaveRequested() {
        RecordVO record = mapViewToModel();
        saveRecord(record);
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

    private void saveRecord(final RecordVO record) {
        AppCache.getRecordStore().save(BookVO.Type.BOOK, record);
        History.back();
    }
    
    private RecordVO mapViewToModel() {
        RecordVO vo = new BookVO();
        vo.put(BookVO.BookField.AUTHOR, view.getAuthor());
        return vo;
    }
    
    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////

    @Override
    public void validatePublishedDate() {
        boolean isValidDate = false;
        String date = view.getPublishedDate();
        if (date.isEmpty()){
            isValidDate = true;
        }
        else {
            try {
                Integer.parseInt(date);
                isValidDate = date.length() == 4;
            }
            catch (NumberFormatException e) {
                isValidDate = false;
            } 
        }
        
        if (isValidDate) {
            view.setPublishedDateValidationState(ValidationState.CLEAR, null);
        }
        else {
            view.setPublishedDateValidationState(ValidationState.ERROR, "This must be a valid year.");
        }
    }

}
