package com.jgefroh.rms.client.mvp.presenters;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgefroh.rms.client.events.LoginSucceeded;
import com.jgefroh.rms.client.mvp.models.LoginDTO;
import com.jgefroh.rms.client.mvp.views.interfaces.LoginView;
import com.jgefroh.rms.client.mvp.views.interfaces.LoginView.Presenter;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil.AppearanceType;
import com.jgefroh.rms.client.services.LoginService;
import com.jgefroh.rms.client.services.LoginServiceAsync;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;

/**
 * @author Joseph Gefroh
 */
public class LoginPresenter implements Presenter {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private LoginView view;
    private ClientFactory clientFactory;
    private LoginServiceAsync loginService = GWT.create(LoginService.class);

    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public LoginPresenter(final ClientFactory clientFactory) {
         this.clientFactory = clientFactory;
    }
    

    //////////////////////////////////////////////////
    // Methods - MVP
    //////////////////////////////////////////////////

    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    @Override
    public void bind(final LoginView view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    
    //////////////////////////////////////////////////
    // Methods - Login
    //////////////////////////////////////////////////

    @Override
    public void requestLogin(final String username, final String password) {
        view.setLoading(true);
        if (isLoginValid(username, password)) {
            LoginDTO credentials = convertCredentialsToDTO(username, password);
            login(credentials);
        }
    }

    private boolean isLoginValid(final String username, final String password) {
        boolean hasValidUsername = isProvided(username);
        boolean hasValidPassword = isProvided(password);
        return hasValidUsername && hasValidPassword;
    }

    private boolean isProvided(final String value) {
        if (value == null) {
            return false;
        }
        return true;
    }

    private LoginDTO convertCredentialsToDTO(final String username, final String password) {
        LoginDTO dto = new LoginDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        return dto;
    }

    private void login(final LoginDTO credentials) {
        loginService.login(credentials, new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(final Throwable caught) {
                view.setLoading(false);
            }

            @Override
            public void onSuccess(final Boolean result) {
                view.setLoading(false);
                if (result == true) {
                    AppCache.getAppBus().fireEvent(new LoginSucceeded());
                }
                else {
                    view.showFormMessage("Unable to login. The credentials you provided were invalid.", AppearanceType.DANGER);
                }
            }
        });
    }
    
}
