package com.jgefroh.rms.client.mvp.views.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.jgefroh.rms.client.mvp.views.widgets.interfaces.HasValidation;


/**
 * Extend this to make your own fields.
 * @author Joseph Gefroh
 */
public abstract class AbstractField extends Composite implements HasValidation  {
    
    public interface CSSClass extends SafeHtmlTemplates {
        @Template("form-control-feedback glyphicon {0}")
        SafeHtml glyphicon(final String iconName);
        
        @Template("form-group has-feedback {0}")
        SafeHtml group(final String formValidationState);
    }

    private static final CSSClass HTML = GWT.create(CSSClass.class);
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
     
    @UiField LabelElement label;
    @UiField DivElement group;
    @UiField SpanElement message;
    @UiField SpanElement glyph;
    @UiField ParagraphElement help;
    @UiField DivElement helpSection;
    @UiField DivElement inputSection;
    @UiField SpanElement required;
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public AbstractField() {
    }

    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    public void setLabel(final String text) {
        label.setInnerText(text);
    }
    
    public void setMessage(final String text) {
        message.setInnerText(text);
    }
    
    public void setHelp(final String text) {
        help.setInnerText(text);
    }
    
    public void setHelpVisible(final boolean isVisible) {
        helpSection.getStyle().setDisplay(isVisible ? Display.INLINE : Display.NONE);
        inputSection.setClassName(isVisible ? "col-xs-6" : "col-xs-12");
        helpSection.setClassName(isVisible ? "col-xs-6" : null);
    }
    
    public void setRequired(final boolean isRequired) {
        if (isRequired) {
            markRequired();
        }
        else {
            markOptional();
        }
    }
    
    public void markRequired() {
        required.setInnerText("*");
    }
    
    public void markOptional() {
        required.setInnerText(null);
    }
    
    @Override
    public void markValid() {
        group.setClassName(HTML.group("has-success").asString());
        glyph.setClassName(HTML.glyphicon("glyphicon-ok").asString());
    }

    @Override
    public void markInvalid() {
        group.setClassName(HTML.group("has-error").asString());
        glyph.setClassName(HTML.glyphicon("glyphicon-remove").asString());
    }
    
    @Override
    public void markNormal() {
        group.setClassName(HTML.group("").asString());
        glyph.setClassName(HTML.glyphicon("").asString());
    }
}
