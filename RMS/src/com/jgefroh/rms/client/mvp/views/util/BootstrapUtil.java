package com.jgefroh.rms.client.mvp.views.util;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.jgefroh.rms.client.mvp.views.constants.ValidationState;
import com.jgefroh.rms.client.resources.Resources;



/**
 * @author Joseph Gefroh
 */
public class BootstrapUtil {
    private static final BootstrapComponents BOOT = GWT.create(BootstrapComponents.class);

    //////////////////////////////////////////////////
    // Inner classes and interfaces
    //////////////////////////////////////////////////
    
    public interface BootstrapComponents extends SafeHtmlTemplates {
        @Template("<div class=\"alert alert-danger alert-dismissable col-md-6 col-md-offset-3\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button><span><strong>Error! - </strong>{0}</span></div>")
        SafeHtml createAlertDanger(String message);
    }
    
    public enum FormGroupFeedback {
        SUCCESS("has-success"),
        WARNING("has-warning"),
        ERROR("has-error");
        
        private String css;
        
        private FormGroupFeedback(final String css) {
            this.css = css;
        }
        
        public String getCSS() {
            return css;
        }
    }
    
    public enum GlyphIcon {
        SUCCESS("glyphicon-ok"),
        WARNING("glyphicon-warning"),
        ERROR("glyphicon-remove");
        
        private String css;
        
        private GlyphIcon(final String css) {
            this.css = css;
        }
        
        public String getCSS() {
            return css;
        }
    }

    
    public enum AppearanceType {
        INFO("-info"),
        SUCCESS("-success"),
        WARNING("-warning"),
        DANGER("-danger");
        
        private String dashType;
        
        private AppearanceType(final String dashType) {
            this.dashType = dashType;
        }
        
        public String getDashType() {
            return dashType;
        }
    }

    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    public static void markField(final ValidationState state, final DivElement formGroupElement, final SpanElement glyphElement, final SpanElement messageElement, final String message) {
        setFieldValidationState(state, formGroupElement, glyphElement);
        messageElement.setInnerText(message);
    }
    
    /**
     * Sets the validation state of a field and its associated elements.
     */
    public static void setFieldValidationState(final ValidationState state, final DivElement formGroupElement, final SpanElement glyphElement) {
        clearFormGroupValidationCSS(formGroupElement);
        clearGlyphIconValidationCSS(glyphElement);
        FormGroupFeedback groupState = null;
        GlyphIcon glyphIcon = null;
        
        switch (state) {
            case ERROR:
                groupState = FormGroupFeedback.ERROR;
                glyphIcon = GlyphIcon.ERROR;
                break;
            case SUCCESS:
                groupState = FormGroupFeedback.SUCCESS;
                glyphIcon = GlyphIcon.SUCCESS;
                break;
            case WARNING:
                groupState = FormGroupFeedback.WARNING;
                glyphIcon = GlyphIcon.WARNING;
                break;
            default:
                break;
        }
        
        if (formGroupElement != null && groupState != null) {
            formGroupElement.addClassName(groupState.getCSS());
        }
        
        if (glyphElement != null && glyphIcon != null) {
            glyphElement.addClassName(glyphIcon.getCSS());
        }
        
     }
    
    public static void setAlertDanger(final DivElement container, final String message) {
        container.setInnerSafeHtml(BOOT.createAlertDanger(message));
        container.addClassName(Resources.INSTANCE.CSS().getName());
     }
    
    private static void clearFormGroupValidationCSS(final DivElement formGroupElement) {
        if (formGroupElement != null) {
            formGroupElement.removeClassName(FormGroupFeedback.SUCCESS.getCSS());
            formGroupElement.removeClassName(FormGroupFeedback.WARNING.getCSS());
            formGroupElement.removeClassName(FormGroupFeedback.ERROR.getCSS());
        }
    }
    
    private static void clearGlyphIconValidationCSS(final SpanElement glyphIconElement) {
        if (glyphIconElement != null) {
            glyphIconElement.removeClassName(GlyphIcon.SUCCESS.getCSS());
            glyphIconElement.removeClassName(GlyphIcon.WARNING.getCSS());
            glyphIconElement.removeClassName(GlyphIcon.ERROR.getCSS());
        }
    }
    
    public static void show(final Element element) {
        element.removeClassName("hidden");
        element.addClassName("show");
    }
    
    public static void hide(final Element element) {
        element.removeClassName("show");
        element.addClassName("hidden");
    }
    
    
}
