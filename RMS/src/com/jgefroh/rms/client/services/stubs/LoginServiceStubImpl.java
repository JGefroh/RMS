package com.jgefroh.rms.client.services.stubs;

import java.util.logging.Logger;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgefroh.rms.client.mvp.models.LoginDTO;
import com.jgefroh.rms.client.services.LoginService;
import com.jgefroh.rms.client.services.LoginServiceAsync;
import com.jgefroh.rms.shared.RMSException;

/**
 * @author Joseph Gefroh
 */
public class LoginServiceStubImpl implements LoginService, LoginServiceAsync {

    private static final Logger LOGGER = Logger.getLogger(LoginServiceStubImpl.class.getName());

    //////////////////////////////////////////////////
    // Methods - Service
    //////////////////////////////////////////////////

    @Override
    public boolean login(final LoginDTO credentials) throws RMSException {
        if (credentials == null) {
            throw new RMSException("An attempt was made to login with no credentials.");
        }
        
        if ("guest".equals(credentials.getPassword()) && "guest".equals(credentials.getUsername())) {
            return true;
        }
        return false;
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Async Stub
    //////////////////////////////////////////////////

    @Override
    public void login(final LoginDTO credentials, final AsyncCallback<Boolean> callback) {
        Timer timer = new Timer() {
            @Override
            public void run() {
                try {
                    boolean loggedIn = login(credentials);
                    callback.onSuccess(loggedIn);
                }
                catch (RMSException e) {
                    callback.onFailure(e);
                }
            }
        };
        timer.schedule(900);
    }
}
