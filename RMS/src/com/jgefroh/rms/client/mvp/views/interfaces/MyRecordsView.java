package com.jgefroh.rms.client.mvp.views.interfaces;

import java.util.List;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.jgefroh.rms.client.mvp.models.RecordVO;


/**
 * @author Joseph Gefroh
 */
public interface MyRecordsView extends IsWidget {
    
    /**
     * @author Joseph Gefroh
     */
    public interface Presenter {
        void goTo(Place place);
        void bind(MyRecordsView view);
        void removeAllHandlers();
        void loadRecords();
    }
    
    void setPresenter(Presenter presenter);
    void showRecords(List<RecordVO> records);
}
