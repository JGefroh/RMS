/**
 * 
 */
package com.jgefroh.rms.client.mvp.views.impls;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.views.composites.AlertPanel;
import com.jgefroh.rms.client.mvp.views.composites.AlertPanel.AlertType;
import com.jgefroh.rms.client.mvp.views.constants.ValidationState;
import com.jgefroh.rms.client.mvp.views.interfaces.AccountView;
import com.jgefroh.rms.client.mvp.views.widgets.PasswordField;
import com.jgefroh.rms.client.mvp.views.widgets.StrengthMeter;
import com.jgefroh.rms.client.mvp.views.widgets.TextField;
import com.jgefroh.rms.client.mvp.views.widgets.interfaces.HasValidation;
import com.jgefroh.rms.client.resources.MessageConstants;
import com.jgefroh.rms.client.util.PasswordStrengthCalculator.PasswordStrength;


/**
 * @author Joseph Gefroh
 */
public class AccountViewImpl extends Composite implements AccountView {
    
    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    interface UIBinder extends UiBinder<Widget, AccountViewImpl> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    
    @UiField AlertPanel alertPanel;
    @UiField StrengthMeter strengthMeter;
    @UiField TextField fullname;
    @UiField TextField nickname;
    @UiField TextField email;
    @UiField PasswordField newPassword;
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Presenter presenter;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public AccountViewImpl() {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
        initInputProperties();
        reset();
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////
    
    private void initInputProperties() {
        fullname.setPlaceholder(MessageConstants.INSTANCE.fullNamePrompt());
        nickname.setPlaceholder(MessageConstants.INSTANCE.nickNamePrompt());
    }


    //////////////////////////////////////////////////
    // Methods - Event Handlers
    //////////////////////////////////////////////////

    @UiHandler("btnSave")
    void requestSave(final ClickEvent event) {
        presenter.requestSave();
    }
    
    @UiHandler("newPassword")
    void updateStrengthMeter(final KeyUpEvent event) {
        presenter.updateStrengthMeter(newPassword.getValueOrNull());
    }
    
    @UiHandler("email")
    void validateEmail(final BlurEvent event) {
        presenter.validateEmail(getEmail());
    }
    
    @UiHandler("fullname")
    void validateFullname(final BlurEvent event) {
        presenter.validateFullname(getFullname());
    }
    
    @UiHandler("nickname")
    void validateNickname(final BlurEvent event) {
        presenter.validateNickname(getNickname());
    }
    
    
    //////////////////////////////////////////////////
    // Methods - MVP
    //////////////////////////////////////////////////
    
    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }
    

    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////

    @Override
    public void reset() {
        resetFields();
        resetValidation();
        alertPanel.hide();
    }


    private void resetFields() {
        fullname.setValue(null);
        nickname.setValue(null);
        email.setValue(null);
        newPassword.setValue(null);
        strengthMeter.reset();
    }
    
    private void resetValidation() {
        setEmailMessage(null);
        setFullnameMessage(null);
        setNicknameMessage(null);
        alertPanel.hide();
    }

    
    @Override
    public void showAlert(final AlertType type, final String intro, final String message) {
        alertPanel.show(type, intro, message);
    }
    
    @Override
    public void showAlert(final AlertType type, final String intro, final String message, final int ms) {
        alertPanel.show(type, intro, message, ms);
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Getters (Values)
    //////////////////////////////////////////////////
    
    @Override
    public String getNewPassword() {
        return newPassword.getValueOrNull();
    }
    
    @Override
    public String getEmail() {
        return email.getValueOrNull();
    }
    
    @Override
    public String getFullname() {
        return fullname.getValueOrNull();
    }
    
    @Override
    public String getNickname() {
        return nickname.getValueOrNull();
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Setters (Values)
    //////////////////////////////////////////////////

    @Override
    public void setFullname(final String fullnameText) {
        fullname.setValue(fullnameText);
    }

    @Override
    public void setEmail(final String emailText) {
        email.setValue(emailText);
    }

    @Override
    public void setNickname(final String nicknameText) {
        nickname.setValue(nicknameText);
    }

    @Override
    public void setPasswordStrength(final PasswordStrength strength) {
        strengthMeter.setPasswordStrength(strength);
    }

    
    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////
    
    private void setValidationState(final ValidationState state, final HasValidation validatable) {
        if (ValidationState.ERROR.equals(state)) {
            validatable.markInvalid();
        }
        else {
            validatable.markNormal();
        }
    }
    
    @Override
    public void setEmailMessage(final String message) {
        email.setMessage(message);
        setValidationState(message == null ? ValidationState.CLEAR : ValidationState.ERROR, email);
    }

    @Override
    public void setFullnameMessage(final String message) {
        fullname.setMessage(message);
        setValidationState(message == null ? ValidationState.CLEAR : ValidationState.ERROR, fullname);
    }

    @Override
    public void setNicknameMessage(final String message) {
        nickname.setMessage(message);
        setValidationState(message == null ? ValidationState.CLEAR : ValidationState.ERROR, nickname);
    }
}
