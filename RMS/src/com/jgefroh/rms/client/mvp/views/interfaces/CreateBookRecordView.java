package com.jgefroh.rms.client.mvp.views.interfaces;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.jgefroh.rms.client.mvp.views.constants.ValidationState;


/**
 * @author Joseph Gefroh
 */
public interface CreateBookRecordView extends IsWidget {

    /**
     * @author Joseph Gefroh
     */
    public interface Presenter {
        void goTo(Place place);
        void bind(CreateBookRecordView view);
        void validatePublishedDate();
        void onSaveRequested();
        void onExamineRequested();
        void onSubmitRequested();
    }

    void setPresenter(Presenter presenter);
    void setPublishedDateValidationState(ValidationState state, String message);

    String getPublishedDate();
    String getAuthor();

}
