/**
 * 
 */
package com.jgefroh.rms.client.mvp.views.impls;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.jgefroh.rms.client.events.ActionRequested;
import com.jgefroh.rms.client.mvp.views.composites.RecordEditActionPanel;
import com.jgefroh.rms.client.mvp.views.composites.RecordEditActionPanel.Action;
import com.jgefroh.rms.client.mvp.views.constants.ValidationState;
import com.jgefroh.rms.client.mvp.views.interfaces.PurchaseOrderRecordCreateView;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil;


/**
 * @author Joseph Gefroh
 */
public class PurchaseOrderRecordCreateViewImpl extends Composite implements PurchaseOrderRecordCreateView {


    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    interface CreatePurchaseOrderRecordViewImplUiBinder extends UiBinder<Widget, PurchaseOrderRecordCreateViewImpl> {}
    private static CreatePurchaseOrderRecordViewImplUiBinder uiBinder = GWT.create(CreatePurchaseOrderRecordViewImplUiBinder.class);
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    @UiField RecordEditActionPanel actionPanelTop;
    @UiField RecordEditActionPanel actionPanelBottom;
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Presenter presenter;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public PurchaseOrderRecordCreateViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }


    //////////////////////////////////////////////////
    // Methods - Event Handlers
    //////////////////////////////////////////////////

    @UiHandler({"actionPanelTop", "actionPanelBottom"})
    void onActionRequested(final ActionRequested event) {
        if (Action.SAVE.equals(event.getAction())) {
            presenter.onSaveRequested();
        }
        else if (Action.EXAMINE.equals(event.getAction())) {
            presenter.onExamineRequested();
        }
        else if (Action.SUBMIT.equals(event.getAction())) {
            presenter.onSubmitRequested();
        }
    }

    
    //////////////////////////////////////////////////
    // Methods - Interface Overrides
    //////////////////////////////////////////////////
    
    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }
    

    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////
}
