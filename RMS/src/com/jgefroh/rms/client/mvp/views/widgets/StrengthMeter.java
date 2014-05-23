package com.jgefroh.rms.client.mvp.views.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil;
import com.jgefroh.rms.client.util.PasswordStrengthCalculator.PasswordStrength;

/**
 * @author Joseph Gefroh
 */
public class StrengthMeter extends Composite {

    interface UIBinder extends UiBinder<Widget, StrengthMeter> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    @UiField LabelElement label;
    @UiField ParagraphElement help;
    @UiField DivElement passwordStrengthStrong;
    @UiField DivElement passwordStrengthBetter;
    @UiField DivElement passwordStrengthMedium;
    @UiField DivElement passwordStrengthWeak;
    @UiField SpanElement passwordStrengthWeakLabel;
    @UiField SpanElement passwordStrengthMediumLabel;
    @UiField SpanElement passwordStrengthBetterLabel;
    @UiField SpanElement passwordStrengthStrongLabel;


    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public StrengthMeter() {
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////

    public void setLabel(final String text) {
        label.setInnerText(text);
    }
    
    public void setHelp(final String text) {
        help.setInnerText(text);
    }
    
    public void reset() {
        resetPasswordStrengthLabels();
        resetPasswordStrengthMeter();
    }
    
    private void resetPasswordStrengthMeter() {
        BootstrapUtil.hide(passwordStrengthStrong);
        BootstrapUtil.hide(passwordStrengthBetter);
        BootstrapUtil.hide(passwordStrengthMedium);
        BootstrapUtil.hide(passwordStrengthWeak);
    }
    
    private void resetPasswordStrengthLabels() {
        BootstrapUtil.hide(passwordStrengthStrongLabel);
        BootstrapUtil.hide(passwordStrengthBetterLabel);
        BootstrapUtil.hide(passwordStrengthMediumLabel);
        BootstrapUtil.hide(passwordStrengthWeakLabel);
    }

    public void setPasswordStrength(final PasswordStrength strength) {
        reset();
        showPasswordStrengthMeter(strength);
        showPasswordStrengthLabel(strength);
    }
    
    private void showPasswordStrengthMeter(final PasswordStrength strength) {
        switch (strength) {
            case STRONG:
                BootstrapUtil.show(passwordStrengthStrong);
            case BETTER:
                BootstrapUtil.show(passwordStrengthBetter);
            case MEDIUM:
                BootstrapUtil.show(passwordStrengthMedium);
            case WEAK:
                BootstrapUtil.show(passwordStrengthWeak);
            case NONE:
            default:
                break;
        }
    }
    
    private void showPasswordStrengthLabel(PasswordStrength strength) {
        resetPasswordStrengthLabels();
        switch (strength) {
            case STRONG:
                BootstrapUtil.show(passwordStrengthStrongLabel);
                break;
            case BETTER:
                BootstrapUtil.show(passwordStrengthBetterLabel);
                break;
            case MEDIUM:
                BootstrapUtil.show(passwordStrengthMediumLabel);
                break;
            case WEAK:
                BootstrapUtil.show(passwordStrengthWeakLabel);
                break;
            case NONE:
            default:
                break;
        }
    }
}
