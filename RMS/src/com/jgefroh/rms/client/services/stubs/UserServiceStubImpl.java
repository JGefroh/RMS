package com.jgefroh.rms.client.services.stubs;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.mvp.presenters.AccountPresenter;
import com.jgefroh.rms.client.services.UserService;
import com.jgefroh.rms.client.services.UserServiceAsync;

/**
 * @author Joseph Gefroh
 */
public class UserServiceStubImpl implements UserService, UserServiceAsync {

    private static final Logger LOGGER = Logger.getLogger(UserServiceStubImpl.class.getName());

    //////////////////////////////////////////////////
    // Methods - Service
    //////////////////////////////////////////////////

    @Override
    public Integer get(int test) {
        LOGGER.log(Level.INFO, "Reached async.");
        return -1;
    }
    
    @Override
    public boolean update(final AccountDTO user) {
        LOGGER.log(Level.INFO, "User (id:'" + user.getUserID() + "') attempted to save account data.");
        if ("1".equals(user.getUserID())) {
            return true;
        }
        return false;
    }

    //////////////////////////////////////////////////
    // Methods - Async
    //////////////////////////////////////////////////

    @Override
    public void get(int test, AsyncCallback<Integer> callback) {
        get(test);
        callback.onSuccess(213);
    }

    @Override
    public void update(AccountDTO account, AsyncCallback<Boolean> callback) {
        callback.onSuccess(update(account));
    }
}
