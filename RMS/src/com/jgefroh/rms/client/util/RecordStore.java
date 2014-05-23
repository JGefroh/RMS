package com.jgefroh.rms.client.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jgefroh.rms.client.mvp.models.RecordVO;
import com.jgefroh.rms.client.mvp.models.RecordVO.RecordType;

/**
 * Acts as a fake database/backend for the RMS program.
 * @author Joseph Gefroh
 */
public class RecordStore {

    //////////////////////////////////////////////////
    // Classes
    //////////////////////////////////////////////////
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    public static Map<RecordType, List<RecordVO>> recordsByType;
    
    
    //////////////////////////////////////////////////
    // Constructor
    //////////////////////////////////////////////////
    
    public RecordStore() {
        recordsByType = new HashMap<RecordType, List<RecordVO>>();
    }
    
    
    //////////////////////////////////////////////////
    // Methods - API
    //////////////////////////////////////////////////
    
    public void save(final RecordType type, final RecordVO record) {
        List<RecordVO> records = recordsByType.get(type);
        if (records == null) {
            records = new ArrayList<RecordVO>();
            recordsByType.put(type, records);
        }
        
        if (!records.contains(record)) {
            records.add(record);
        }
    }

    public List<RecordVO> getRecords(final RecordType type) {
        return recordsByType.get(type) == null ? Collections.<RecordVO>emptyList() : recordsByType.get(type);
    }
    
    
    //////////////////////////////////////////////////
    // Methods - Helpers
    //////////////////////////////////////////////////

}