package com.jgefroh.rms.client.mvp.views.composites;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.jgefroh.rms.client.mvp.models.HasID;
import com.jgefroh.rms.client.resources.CSSCellTableResource;

/**
 * @author Joseph Gefroh
 */
public abstract class AbstractRecordTable<T extends HasID> extends Composite {

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
        SafeHtml dropdownActions(Integer recordNumber);
    }
    
    private static final Logger LOGGER = Logger.getLogger(AbstractRecordTable.class.getName());
    
    //////////////////////////////////////////////////
    // Fields - UI
    //////////////////////////////////////////////////

    private CellTable<T> table;
    private ListDataProvider<T> model;

    
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

    public void showRecords(final List<T> records) {
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
        table = new CellTable<T>(NUM_VISIBLE_ITEMS, tableResources);
    }
    
    private void initModel() {
        model = new ListDataProvider<T>();
        model.addDataDisplay(table);
    }
    
    private void initCommonColumns() {
        TextColumn<T> actionCol = new TextColumn<T>() {
            @Override
            public void render(final Context context, final T record, final SafeHtmlBuilder sb) {
                sb.appendHtmlConstant((new RecordDropdownMenu(record.getID()).getElement().getString()));
            }
            
            @Override
            public String getValue(final T record) {
                return null;
            }
        };
        
        TextColumn<T> idCol = new TextColumn<T>() {
            @Override
            public String getValue(final T record) {
                return String.valueOf(record.getID());
            }
        };
        
        table.addColumn(actionCol, HEADER_ACTIONS);
        table.addColumn(idCol, HEADER_ID);
    }

    public CellTable<T> getTable() {
        return table;
    }
}
