package com.jgefroh.rms.client.mvp.views.composites;

import com.google.gwt.user.cellview.client.TextColumn;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.jgefroh.rms.client.mvp.models.BookVO.BookField;
import com.jgefroh.rms.client.mvp.models.RecordVO;

/**
 * @author Joseph Gefroh
 */
public class BookRecordTable extends AbstractRecordTable {

    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    private static final String HEADER_AUTHOR = "Author";    
    private static final String HEADER_TITLE = "Title";   
    
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public BookRecordTable() {
    }
    

    //////////////////////////////////////////////////
    // Methods - Abstract
    //////////////////////////////////////////////////
    
    @Override
    protected void initColumns() {
        TextColumn<RecordVO> authorCol = new TextColumn<RecordVO>() {
            @Override
            public String getValue(RecordVO object) {
                return object.get(BookField.AUTHOR);
            }
        };
        
        TextColumn<RecordVO> titleCol = new TextColumn<RecordVO>() {
            @Override
            public String getValue(RecordVO object) {
                return object.get(BookField.TITLE);
            }
        };
        
        super.getTable().addColumn(authorCol, HEADER_AUTHOR);
        super.getTable().addColumn(titleCol, HEADER_TITLE);
    }
    
    @Override
    protected void initSorters() {
        
    }

    @Override
    protected void initDimensions() {
        
    }

    //////////////////////////////////////////////////
    // Methods - Actions
    //////////////////////////////////////////////////

    
    //////////////////////////////////////////////////
    // Methods - Init
    //////////////////////////////////////////////////
}
