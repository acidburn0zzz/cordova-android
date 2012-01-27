package com.phonegap.test;

import com.phonegap.CordovaWebView;
import com.phonegap.api.PluginManager;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class CordovaSplashTest extends ActivityInstrumentationTestCase2<PhoneGapSplash> {

    private PhoneGapSplash testActivity;
    private FrameLayout containerView;
    private LinearLayout innerContainer;
    private CordovaWebView testView;
    
    public CordovaSplashTest()
    {
        super("com.phonegap.test.activities",PhoneGapSplash.class);
    }
    
    protected void setUp() throws Exception{
        super.setUp();
        testActivity = this.getActivity();
        containerView = (FrameLayout) testActivity.findViewById(android.R.id.content);
        innerContainer = (LinearLayout) containerView.getChildAt(0);
        testView = (CordovaWebView) innerContainer.getChildAt(0);
        
    }
    
    public void testPreconditions(){
        assertNotNull(innerContainer);
        assertNotNull(testView);
    }
    

    public void testForCordovaView() {
        String className = testView.getClass().getSimpleName();
        assertTrue(className.equals("CordovaWebView"));
    }
    
    public void testForPluginManager() {
        CordovaWebView v = (CordovaWebView) testView;
        PluginManager p = v.getPluginManager();
        assertNotNull(p);
        String className = p.getClass().getSimpleName();
        assertTrue(className.equals("PluginManager"));
    }

    public void testBackButton() {
        CordovaWebView v = (CordovaWebView) testView;
        assertFalse(v.checkBackKey());
    }
}