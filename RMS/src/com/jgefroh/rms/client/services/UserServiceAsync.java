package com.jgefroh.rms.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.mvp.models.UserVO;


/**
 * @author Joseph Gefroh
 */
public interface UserServiceAsync {

    void update(AccountDTO account, AsyncCallback<Boolean> callback);
    void get(int test, AsyncCallback<Integer> callback);
}
