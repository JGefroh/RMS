package com.jgefroh.rms.client.mvp.views.util;

import com.jgefroh.rms.client.mvp.views.constants.ValidationState;
import com.jgefroh.rms.client.mvp.views.widgets.AbstractField;
import com.jgefroh.rms.client.mvp.views.widgets.interfaces.HasValidation;

/**
 * @author Joseph Gefroh
 */
public final class WidgetValidationUtil {

    private WidgetValidationUtil() {
        throw new UnsupportedOperationException("Utility classes should not be instantiated.");
    }
    
    public static void setValidationState(final ValidationState state, final HasValidation validatable) {
        if (validatable == null) {
            return;
        }
        
        if (ValidationState.ERROR.equals(state)) {
            validatable.markInvalid();
        }
        else {
            validatable.markNormal();
        }
    }
    
    /**
     * Sets the passed widget's error message. If the message is null, the widget's validation state is marked as normal.
     */
    public static void setFieldErrorMessage(final AbstractField field, final String message) {
        if (field != null) {
            field.setMessage(message);
            setValidationState(message == null ? ValidationState.CLEAR : ValidationState.ERROR, field);
        }
    }
    
}
