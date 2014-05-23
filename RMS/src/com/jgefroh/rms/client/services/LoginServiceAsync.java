package com.jgefroh.rms.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgefroh.rms.client.mvp.models.LoginDTO;


/**
 * @author Joseph Gefroh
 */
public interface LoginServiceAsync {
    void login(LoginDTO credentials, AsyncCallback<Boolean> callback);
}
