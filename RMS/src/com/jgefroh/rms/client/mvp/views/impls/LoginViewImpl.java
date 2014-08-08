/**
 * 
 */
package com.jgefroh.rms.client.mvp.views.impls;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.views.interfaces.LoginView;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil;
import com.jgefroh.rms.client.mvp.views.widgets.DismissableAlert;
import com.jgefroh.rms.client.mvp.views.widgets.PasswordField;
import com.jgefroh.rms.client.mvp.views.widgets.TextField;
import com.jgefroh.rms.client.resources.MessageConstants;


/**
 * @author Joseph Gefroh
 */
public class LoginViewImpl extends Composite implements LoginView {

    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    interface LoginViewImplUiBinder extends UiBinder<Widget, LoginViewImpl> {}
    private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    
    @UiField TextField username;
    @UiField PasswordField password;
    @UiField Button btnLogin;
    @UiField DivElement formMessageContainer;
    @UiField DismissableAlert alert;
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Presenter presenter;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public LoginViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        initInputProperties();
        initButtonProperties();
    }
    
    
    //////////////////////////////////////////////////
    // Initialization
    //////////////////////////////////////////////////
    
    private void initInputProperties() {
        username.setPlaceholder(MessageConstants.INSTANCE.usernamePrompt());
        password.setPlaceholder(MessageConstants.INSTANCE.passwordPrompt());
    }
    
    private void initButtonProperties() {
        btnLogin.getElement().setPropertyString("type", "button");
    }


    //////////////////////////////////////////////////
    // Methods - MVP
    //////////////////////////////////////////////////
    
    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Event Handlers
    //////////////////////////////////////////////////
    
    @UiHandler("btnLogin")
    void requestLogin(final ClickEvent event) {
        presenter.requestLogin(username.getValueOrNull(), password.getValueOrNull());
    }

    @UiHandler("password")
    void requestLogin(final KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            presenter.requestLogin(username.getValueOrNull(), password.getValueOrNull());
        }
    }

    
    //////////////////////////////////////////////////
    // Methods - Getters
    //////////////////////////////////////////////////
    
    @Override
    public String getUsername() {
        return username.getValueOrNull();
    }
    
    @Override
    public String getPassword() {
        return password.getValueOrNull();
    }

    
    //////////////////////////////////////////////////
    // Methods - Validation
    //////////////////////////////////////////////////

    @Override
    public void showFormMessage(final String message) {
        alert.setLead("Error!");
        alert.setText(message);
        alert.show();
    }
    
    @Override
    public void setLoading(final boolean isLoading) {
        username.setEnabled(!isLoading);
        password.setEnabled(!isLoading);
        btnLogin.setEnabled(!isLoading);
    }
}
