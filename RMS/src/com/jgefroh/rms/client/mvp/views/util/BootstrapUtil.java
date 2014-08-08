package com.jgefroh.rms.client.mvp.views.util;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.jgefroh.rms.client.resources.Resources;



/**
 * @author Joseph Gefroh
 */
public class BootstrapUtil {

    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    public static void show(final Element element) {
        element.removeClassName("hidden");
        element.addClassName("show");
    }
    
    public static void hide(final Element element) {
        element.removeClassName("show");
        element.addClassName("hidden");
    }
}
