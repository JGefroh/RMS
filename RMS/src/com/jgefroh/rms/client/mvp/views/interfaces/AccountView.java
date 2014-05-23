package com.jgefroh.rms.client.mvp.views.interfaces;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.jgefroh.rms.client.mvp.models.UserVO;
import com.jgefroh.rms.client.mvp.views.composites.AlertPanel.AlertType;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil.AppearanceType;
import com.jgefroh.rms.client.util.PasswordStrengthCalculator.PasswordStrength;


/**
 * @author Joseph Gefroh
 */
public interface AccountView extends IsWidget {
    
    /**
     * @author Joseph Gefroh
     */
    public interface Presenter {
        void goTo(Place place);
        void bind(AccountView view);
        void mapModelToView(UserVO user);
        void updateStrengthMeter(String password);
        void resetView();
        void requestSave();
        void validateEmail(String email);
        void validateFullname(String string);
        void validateNickname(String nickname);
    }
    
    void setPresenter(Presenter presenter);
    void setFullname(String fullname);
    void setEmail(String email);
    void setNickname(String nickname);
    void setPasswordStrength(PasswordStrength strength);
    void setEmailMessage(String string);
    void setFullnameMessage(String string);
    void setNicknameMessage(String message);
    void reset();
    String getNewPassword();
    String getFullname();
    String getEmail();
    String getNickname();
    void showAlert(AlertType type, String intro, String message);
    void showAlert(AlertType type, String intro, String message, int timer);

















}
