/**
 * 
 */
package com.jgefroh.rms.client.mvp.views.impls;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.jgefroh.rms.client.mvp.models.PurchaseOrderVO;
import com.jgefroh.rms.client.mvp.models.RecordVO;
import com.jgefroh.rms.client.mvp.views.composites.AbstractRecordTable;


/**
 * @author Joseph Gefroh
 */
public class PurchaseOrderRecordTable extends AbstractRecordTable<PurchaseOrderVO> {

    //////////////////////////////////////////////////
    // Interfaces
    //////////////////////////////////////////////////

    interface UIBinder extends UiBinder<Widget, PurchaseOrderRecordTable> {
        UIBinder INSTANCE = GWT.create(UIBinder.class);
    }
    
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    @UiField(provided = true) CellTable<PurchaseOrderVO> table;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public PurchaseOrderRecordTable() {
        super();
        this.table = getTable();
        initWidget(UIBinder.INSTANCE.createAndBindUi(this));
    }


    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////
    

    //////////////////////////////////////////////////
    // Methods - Initialization
    //////////////////////////////////////////////////
    
    @Override
    protected void initColumns() {
    }


    @Override
    protected void initSorters() {
    }


    @Override
    protected void initDimensions() {
    }
}
