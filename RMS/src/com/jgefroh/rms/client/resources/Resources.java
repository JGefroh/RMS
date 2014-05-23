package com.jgefroh.rms.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;


public interface Resources extends ClientBundle {

    public static final Resources INSTANCE = GWT.create(Resources.class);
    @Source("general.css")
    CSSResource CSS();
    
    @Source("images/loading.gif")
    ImageResource imgLoading();
    
    @Source("images/logo.png")
    ImageResource imgLogo();
}
