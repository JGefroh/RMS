package com.jgefroh.rms.client.util;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.jgefroh.rms.client.mvp.models.UserVO;

/**
 * Holds the application's cached data.
 * @author Joseph Gefroh
 */
public class AppCache {
    
    //////////////////////////////////////////////////
    // Fields
    //////////////////////////////////////////////////
    
    private static final EventBus APP_BUS = new SimpleEventBus();
    private static RecordStore recordStore;
    private static UserVO currentUser;

    
    //////////////////////////////////////////////////
    // Methods - Getters
    //////////////////////////////////////////////////
    
    /**
     * Gets the application's singleton event bus.
     * @return  the application's event bus.
     */
    public static EventBus getAppBus() {
        return APP_BUS;
    }


    /**
     * Gets the data of the currently logged in user.
     * @return  the current user
     */
    public static UserVO getCurrentUser() {
        return AppCache.currentUser;
    }
    
    /**
     * Gets the fake record store.
     * @return  the record store
     */
    public static RecordStore getRecordStore() {
        if (recordStore == null) {
            recordStore = new RecordStore();
        }
        return recordStore;
    }
    
    //////////////////////////////////////////////////
    // Methods - Setters
    //////////////////////////////////////////////////
    
    /**
     * Sets the details of the user that is currently logged into the system.
     * @param currentUser   the current user
     */
    public static void setCurrentUser(final UserVO currentUser) {
        AppCache.currentUser = currentUser;
    }
}
