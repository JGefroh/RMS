package com.jgefroh.rms.client.resources;

import com.google.gwt.user.cellview.client.CellTable;


/**
 * @author Joseph Gefroh
 */
public interface CSSCellTableResource extends CellTable.Resources {
    
    @Override
    @Source({CellTable.Style.DEFAULT_CSS, "cellTable.css"})
    TableStyle cellTableStyle();
    
    interface TableStyle extends CellTable.Style {
    }
}
