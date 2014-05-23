package com.jgefroh.rms.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jgefroh.rms.client.mvp.models.AccountDTO;
import com.jgefroh.rms.client.mvp.models.UserVO;

/**
 * @author Joseph Gefroh
 */
@RemoteServiceRelativePath("UserService")
public interface UserService extends RemoteService {
    
    boolean update(AccountDTO account);
    Integer get(int test);
}
