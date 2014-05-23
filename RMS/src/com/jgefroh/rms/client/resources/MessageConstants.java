package com.jgefroh.rms.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.client.Messages.DefaultMessage;


public interface MessageConstants extends Messages {
    public static MessageConstants INSTANCE = GWT.create(MessageConstants.class);
    
    String usernamePrompt();
    String passwordPrompt();
    String fullNamePrompt();
    String nickNamePrompt();
    String changePasswordPrompt();
    String repeatPasswordPrompt();
}
