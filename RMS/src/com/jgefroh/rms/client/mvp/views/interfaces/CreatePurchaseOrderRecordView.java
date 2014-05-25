package com.jgefroh.rms.client.mvp.views.interfaces;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;


/**
 * @author Joseph Gefroh
 */
public interface CreatePurchaseOrderRecordView extends IsWidget {

    public interface Presenter {
        void goTo(Place place);
        void bind(CreatePurchaseOrderRecordView view);
        void onSaveRequested();
        void onExamineRequested();
        void onSubmitRequested();
    }

    void setPresenter(Presenter presenter);
}
