package com.jgefroh.rms.client.mvp.views.widgets.interfaces;

/**
 * @author Joseph Gefroh
 */
public interface HasValidation {
    void markInvalid();
    void markNormal();
    void markValid();
}
