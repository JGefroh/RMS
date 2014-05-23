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
import com.jgefroh.rms.client.mvp.views.interfaces.CreateBookRecordView;
import com.jgefroh.rms.client.mvp.views.util.BootstrapUtil;


/**
 * @author Joseph Gefroh
 */
public class CreateBookRecordViewImpl extends Composite implements CreateBookRecordView {


    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    interface CreateBookRecordViewImplUiBinder extends UiBinder<Widget, CreateBookRecordViewImpl> {}
    private static CreateBookRecordViewImplUiBinder uiBinder = GWT.create(CreateBookRecordViewImplUiBinder.class);
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////
     
    @UiField TextBox authorField;
    
    @UiField DateBox publishedDateField;
    @UiField DivElement publishedDateFormGroup;
    @UiField SpanElement publishedDateMessage;
    @UiField SpanElement publishedDateGlyph;
    
    @UiField RecordEditActionPanel actionPanelTop;
    @UiField RecordEditActionPanel actionPanelBottom;
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Presenter presenter;
    private static final DateTimeFormat PUBLISHED_YEAR_FORMAT = DateTimeFormat.getFormat("yyyy");
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public CreateBookRecordViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        initDateBoxes();
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
    
    @UiHandler("publishedDateField")
    void onPublishedDateValueChange(final ValueChangeEvent<Date> event) {
        presenter.validatePublishedDate();
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
    
    private void initDateBoxes() {
        publishedDateField.getTextBox().addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                presenter.validatePublishedDate();
            }
        });
        
        publishedDateField.setFormat(new DefaultFormat(PUBLISHED_YEAR_FORMAT));
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Getters
    //////////////////////////////////////////////////
    
    @Override
    public String getPublishedDate() {
        String textBoxValue = publishedDateField.getTextBox().getValue();
        return textBoxValue == null ? null : textBoxValue;
    }
    
    @Override
    public String getAuthor() {
        return authorField.getValue().isEmpty() ? null : authorField.getValue();
    }
    
    
    
    
    //////////////////////////////////////////////////
    // Methods - Setters
    //////////////////////////////////////////////////

    @Override
    public void setPublishedDateValidationState(final ValidationState state, final String message) {
        publishedDateMessage.setInnerText(message);
        BootstrapUtil.setFieldValidationState(state, publishedDateFormGroup, publishedDateGlyph);
    }
}
