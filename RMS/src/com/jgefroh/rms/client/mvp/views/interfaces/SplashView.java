package com.jgefroh.rms.client.mvp.views.interfaces;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;


/**
 * @author Joseph Gefroh
 */
public interface SplashView extends IsWidget {
    
    void setPresenter(Presenter presenter);
    
    /**
     * @author Joseph Gefroh
     */
    public interface Presenter {
        void goTo(Place place);
        void bind(SplashView view);
    }

















}
