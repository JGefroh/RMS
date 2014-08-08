package com.jgefroh.rms.client.mvp.views.interfaces;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;


/**
 * @author Joseph Gefroh
 */
public interface LoginView extends IsWidget {

    public interface Presenter {
        void bind(LoginView view);
        void goTo(Place place);
        void requestLogin(String username, String password);
    }


    String getPassword();
    String getUsername();
    void showFormMessage(String message);
    void setLoading(boolean isLoading);
    void setPresenter(Presenter presenter);
}
