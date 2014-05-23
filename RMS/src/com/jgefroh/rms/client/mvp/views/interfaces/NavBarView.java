package com.jgefroh.rms.client.mvp.views.interfaces;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;


/**
 * @author Joseph Gefroh
 */
public interface NavBarView extends IsWidget {
    
    void setPresenter(Presenter presenter);
    void setActiveLink(String baseToken);
    
    
    /**
     * @author Joseph Gefroh
     */
    public interface Presenter {
        void goTo(Place place);
        void bind(NavBarView view);
    }

















}
