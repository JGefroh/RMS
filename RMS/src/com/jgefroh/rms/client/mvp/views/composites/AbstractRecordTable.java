package com.jgefroh.rms.client.mvp.views.composites;

import java.util.List;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.jgefroh.rms.client.mvp.models.RecordVO;
import com.jgefroh.rms.client.mvp.models.RecordVO.CommonField;
import com.jgefroh.rms.client.resources.CSSCellTableResource;

/**
 * @author Joseph Gefroh
 */
public abstract class AbstractRecordTable extends Composite {

    //////////////////////////////////////////////////
    // Templates
    //////////////////////////////////////////////////
    private static final Template CELLS = GWT.create(Template.class);
    private static CellTable.Resources tableResources;
    public interface Template extends SafeHtmlTemplates {
        @Template("<div class=\"btn-group dropdown\">"
                + "<button class=\"btn dropdown-toggle\" data-toggle=\"dropdown\"><span class=\"caret\"></span></button>"
                + "<ul class=\"dropdown-menu\" role=\"menu\">"
                    + "<li><a id=\"dropdown-link-edit\" href=\"index.html#editRecord:{0}\"><span class=\"glyphicon glyphicon-pencil\"></span> Edit</a></li>"
                    + "<li><a href=\"index.html#viewRecord:{0}\"><span class=\"glyphicon glyphicon-eye-open\"></span> View</a></li>"
                    + "<li><a href=\"index.html#deleteRecord:{0}\"><span class=\"glyphicon glyphicon-remove-circle\"></span> Delete</a></li>"
                    + "<li class=\"divider\"></li>"
                    + "<li><a href=\"index.html#deleteRecord:{0}\"><span class=\"glyphicon glyphicon-send\"></span> Submit</a></li>"
                + "</ul>"
            + "</div>")
        SafeHtml dropdownActions(String recordNumber);
    }
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    private CellTable<RecordVO> table;
    private ListDataProvider<RecordVO> model;

    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    private static final int NUM_VISIBLE_ITEMS = 10;
    private static final String HEADER_ID = "ID";
    private static final String HEADER_ACTIONS = "Actions";    
    
    private EventBus eventBus;
    
    
    //////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////
    
    public AbstractRecordTable() {
        eventBus = new SimpleEventBus();
        initTable();
        initModel();
        initCommonColumns();
        initColumns();
        initSorters();
        initDimensions();
    }
    

    //////////////////////////////////////////////////
    // Methods - Abstract
    //////////////////////////////////////////////////
    
    protected abstract void initColumns();
    protected abstract void initSorters();
    protected abstract void initDimensions();

    //////////////////////////////////////////////////
    // Methods - Actions
    //////////////////////////////////////////////////

    public void showRecords(final List<RecordVO> records) {
        model.getList().clear();
        if (records.isEmpty()) {
            table.setLoadingIndicator(new Label("No records found."));
            table.setRowCount(0, true);
        }
        else {
            table.setLoadingIndicator(null);
        }
        model.getList().addAll(records);
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Init
    //////////////////////////////////////////////////
    
    private void initTable() {
        tableResources = GWT.create(CSSCellTableResource.class);
        table = new CellTable<RecordVO>(NUM_VISIBLE_ITEMS, tableResources);
    }
    
    private void initModel() {
        model = new ListDataProvider<RecordVO>();
        model.addDataDisplay(table);
    }
    
    private void initCommonColumns() {
        TextColumn<RecordVO> actionCol = new TextColumn<RecordVO>() {
            @Override
            public void render(Context context, RecordVO object, SafeHtmlBuilder sb) {
                sb.append(CELLS.dropdownActions(object.getValuesByID().get(CommonField.ID)));
            }
            
            @Override
            public String getValue(RecordVO object) {
                return null;
            }
        };
        
        TextColumn<RecordVO> idCol = new TextColumn<RecordVO>() {
            @Override
            public String getValue(RecordVO object) {
                return object.get(CommonField.ID);
            }
        };
        
        table.addColumn(actionCol, HEADER_ACTIONS);
        table.addColumn(idCol, HEADER_ID);
    }

    public CellTable<RecordVO> getTable() {
        return table;
    }
}
