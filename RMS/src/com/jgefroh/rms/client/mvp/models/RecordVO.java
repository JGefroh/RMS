package com.jgefroh.rms.client.mvp.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joseph Gefroh
 */
public abstract class RecordVO {
    
    public interface Field {
    }
    
    public interface RecordType {
    }

    public enum CommonField implements Field {
        ID,
        TYPE
    }
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private Map<Field, String> valuesByID;
    private static int lastUsedID = 0;

    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public RecordVO() {
       valuesByID = new HashMap<Field, String>();
    }
    
    
    //////////////////////////////////////////////////
    // Methods
    //////////////////////////////////////////////////
    
    public void put(final Field field, final String value) {
        this.valuesByID.put(field, value);
    }
    
    public String get(final Field field) {
        return this.valuesByID.get(field);
    }
    
    //////////////////////////////////////////////////
    // Getters
    //////////////////////////////////////////////////
    
    public Map<Field, String> getValuesByID() {
        return this.valuesByID;
    }
    
    
    //////////////////////////////////////////////////
    // Setters
    //////////////////////////////////////////////////
    
    public void setValuesByID(final Map<Field, String> valuesByID) {
        if (valuesByID == null) {
            this.valuesByID = new HashMap<Field, String>();
        }
        else {
            this.valuesByID = valuesByID;
        }
    }

    public int getNewID() {
        return lastUsedID++;
    }
}
