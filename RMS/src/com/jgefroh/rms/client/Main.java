package com.jgefroh.rms.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.jgefroh.rms.client.events.LoginSucceeded;
import com.jgefroh.rms.client.events.LoginSucceededHandler;
import com.jgefroh.rms.client.mvp.models.UserVO;
import com.jgefroh.rms.client.navigation.NavigationWatcher;
import com.jgefroh.rms.client.navigation.RMSActivityMapper;
import com.jgefroh.rms.client.navigation.RMSPlaceHistoryMapper;
import com.jgefroh.rms.client.navigation.places.Code404Place;
import com.jgefroh.rms.client.navigation.places.LoginPlace;
import com.jgefroh.rms.client.navigation.places.SplashPlace;
import com.jgefroh.rms.client.resources.Resources;
import com.jgefroh.rms.client.util.AppCache;
import com.jgefroh.rms.client.util.ClientFactory;
import com.jgefroh.rms.client.util.RecordStore;

public class Main implements EntryPoint {
    
    private ClientFactory clientFactory = GWT.create(ClientFactory.class);
    private RecordStore store;
    private NavigationWatcher navWatch;
    
    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        initResources();
        prepareApplication();
    }

    
    //////////////////////////////////////////////////
    // Methods - Configuration
    //////////////////////////////////////////////////
    
    private void initResources() {
        Resources.INSTANCE.CSS().ensureInjected();
    }

    
    //////////////////////////////////////////////////
    // Methods - Bootstrap
    //////////////////////////////////////////////////
    
    private void prepareApplication() { 
        RootPanel.get("rms-nav").add(createNavPanel());
        PlaceController placeController = clientFactory.getPlaceController();
        ActivityMapper mainActivityMapper = new RMSActivityMapper(clientFactory);
        ActivityManager mainActivityManager = new ActivityManager(mainActivityMapper, clientFactory.getHistoryBus());
        
        SimplePanel appPanel = new SimplePanel();
        RootPanel.get("rms-start").add(appPanel);
        mainActivityManager.setDisplay(appPanel);
    
        PlaceHistoryMapper historyMapper = GWT.create(RMSPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, clientFactory.getHistoryBus(), new Code404Place());
        placeController.goTo(new SplashPlace());
        createGuestUser();
        initNavigationWatcher();
    }
    
    private SimplePanel createNavPanel() {
        SimplePanel navPanel = new SimplePanel();
        navPanel.add(clientFactory.getNavBarView());
        return navPanel;
    }
    
    private void createGuestUser() {
        UserVO guestUser = new UserVO();
        guestUser.setUserID("1");
        guestUser.setFullname("Mister Guest");
        guestUser.setNickname("Guest");
        guestUser.setEmail("guest@example.com");
        AppCache.setCurrentUser(guestUser);
    }
    
    private void initNavigationWatcher () {
        navWatch = new NavigationWatcher(clientFactory);
    }
    
}
