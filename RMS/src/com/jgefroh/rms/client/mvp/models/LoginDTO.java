package com.jgefroh.rms.client.mvp.models;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Joseph Gefroh
 */
public class LoginDTO implements IsSerializable {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private String username;
    private String password;

    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////

    public LoginDTO() {
    }
    
    
    //////////////////////////////////////////////////
    // Getters
    //////////////////////////////////////////////////
    
    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
    

    //////////////////////////////////////////////////
    // Setters
    //////////////////////////////////////////////////
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
}
