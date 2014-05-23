package com.jgefroh.rms.client.mvp.views.composites;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil;

/**
 * @author Joseph Gefroh
 */
public class AlertPanel extends Composite {
    interface AlertPanelUiBinder extends UiBinder<Widget, AlertPanel> {}
    private static AlertPanelUiBinder uiBinder = GWT.create(AlertPanelUiBinder.class);
    
    public enum AlertType {
        INFO("alert-info"),
        DANGER("alert-danger"),
        SUCCESS("alert-success"),
        WARNING("alert-warning");

        private String type;
        
        private AlertType(final String type) {
            this.type = type;
        }
        
        public String getType() {
            return this.type;
        }
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
    
    @UiField SpanElement content;
    @UiField SpanElement contentIntro;
    @UiField DivElement alertPanel;
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Timer hideTimer;
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public AlertPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        initTimer();
        hide();
    }

    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////

    private void initTimer() {
        hideTimer = new Timer() {
            @Override
            public void run() {
                hide();
            }
        };
    }
    
    //////////////////////////////////////////////////
    // UI Events
    //////////////////////////////////////////////////
    
    @UiHandler("btnHide")
    void onCloseClicked(final ClickEvent event) {
        hide();
    }
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    public void show(final AlertType type, final String intro, final String message, final int lifetimeInMS) {
        show(type, intro, message);
        scheduleHide(lifetimeInMS);
    }
    
    public void show(final AlertType type, final String intro, final String message) {
        clearAlertStyles();
        contentIntro.setInnerText(intro);
        content.setInnerText(message);
        if (type != null) {
            alertPanel.addClassName(type.getType());
        }
        BootstrapUtil.show(alertPanel);
    }
    
    public void hide() {
        this.content.setInnerText(null);
        BootstrapUtil.hide(alertPanel);
    }

    
    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////
    
    private void scheduleHide(final int timeTillHideInMS) {
        if (hideTimer.isRunning()) {
            hideTimer.cancel();
        }
        hideTimer.schedule(timeTillHideInMS);
    }
    
    private void clearAlertStyles() {
        AlertType[] types = AlertType.values();
        for (AlertType type : types) {
            alertPanel.removeClassName(type.getType());
        }
    }
}