package com.jgefroh.rms.client.mvp.models;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * The data that holds the information of the current user.
 * @author Joseph Gefroh
 */
public class UserVO implements IsSerializable {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private String userID;
    private String username;
    private String fullname;
    private String nickname;
    private String email;
    

    //////////////////////////////////////////////////
    // Getters
    //////////////////////////////////////////////////
    
    public String getEmail() {
        return email;
    }
    
    public String getFullname() {
        return fullname;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public String getUsername() {
        return username;
    }

    public String getUserID() {
        return this.userID;
    }
    

    //////////////////////////////////////////////////
    // Setters
    //////////////////////////////////////////////////
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }
    
    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public void setUserID(final String userID) {
        this.userID = userID;
    }

}
