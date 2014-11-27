/**
 * 
 */
package com.jgefroh.rms.client.mvp.views.impls;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.models.PurchaseOrderVO;
import com.jgefroh.rms.client.mvp.models.RecordVO;
import com.jgefroh.rms.client.mvp.views.interfaces.MyRecordsView;
import com.jgefroh.rms.client.navigation.places.CreatePurchaseOrderRecordPlace;


/**
 * @author Joseph Gefroh
 */
public class MyRecordsViewImpl extends Composite implements MyRecordsView {

    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////
    
    interface MyRecordsViewImplUiBinder extends UiBinder<Widget, MyRecordsViewImpl> {}
    private static MyRecordsViewImplUiBinder uiBinder = GWT.create(MyRecordsViewImplUiBinder.class);
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    @UiField PurchaseOrderRecordTable table;
    
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Presenter presenter;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public MyRecordsViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
    }


    //////////////////////////////////////////////////
    // Methods - Event Handlers
    //////////////////////////////////////////////////

    @UiHandler("btnCreate")
    void onCreateClicked(final ClickEvent event) {
        presenter.goTo(new CreatePurchaseOrderRecordPlace());
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
    

    @Override
    public void showRecords(final List<RecordVO> records) {
        List<PurchaseOrderVO> records2 = new ArrayList<PurchaseOrderVO>();
        records2.add(new PurchaseOrderVO());
        records2.add(new PurchaseOrderVO());
        table.showRecords(records2);
    }
}
