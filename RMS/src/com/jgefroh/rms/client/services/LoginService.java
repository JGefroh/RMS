package com.jgefroh.rms.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jgefroh.rms.client.mvp.models.LoginDTO;
import com.jgefroh.rms.shared.RMSException;

/**
 * @author Joseph Gefroh
 */
@RemoteServiceRelativePath("LoginService")
public interface LoginService extends RemoteService {
    
    /**
     * Log into the RMS system.
     * @param credentials the credentials to use
     * @return true if successfully logged in; false otherwise
     * @throws RMSException thrown when the credentials are not properly sent
     */
    boolean login(LoginDTO credentials) throws RMSException;
}
