package com.jgefroh.rms.client.mvp.models;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Joseph Gefroh
 */
public class AccountDTO implements IsSerializable {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private String userID;
    private String fullname;
    private String nickname;
    private String email;
    private String newPassword;
    private String currentPassword;
    private String repeatPassword;
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////

    public AccountDTO() {
        
    }
    
    //////////////////////////////////////////////////
    // Getters
    //////////////////////////////////////////////////
    
    public String getUserID() {
        return this.userID;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getFullname() {
        return this.fullname;
    }
    
    public String getNickname() {
        return this.nickname;
    }
    
    public String getCurrentPassword() {
        return this.currentPassword;
    }
     
    public String getNewPassword() {
        return this.newPassword;
    }
    
    public String getRepeatPassword() {
        return this.repeatPassword;
    }

    //////////////////////////////////////////////////
    // Setters
    //////////////////////////////////////////////////
    
    public void setUserID(final String userID) {
        this.userID = userID;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }
    
    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }
    
    public void setCurrentPassword(final String currentPassword) {
        this.currentPassword = currentPassword;
    }
    
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public void setRepeatPassword(final String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    
    
}
