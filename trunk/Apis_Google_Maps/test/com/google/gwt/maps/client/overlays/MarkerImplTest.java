package com.google.gwt.maps.client.overlays;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;

public class MarkerImplTest extends GWTTestCase {

  public static final int ASYNC_DELAY_MS = 5000;
  
  public String getModuleName() {
    return "com.google.gwt.maps.Apis_Google_Maps_ForTests";
  }

  public void testWorks() {
    assertEquals(true, true);
  }
  
  public void testUse() {
    LoadApi.go(new Runnable() {
      public void run() {
        MarkerOptions options = MarkerOptions.newInstance();
        Marker o = Marker.newInstance(options);
        finishTest();
      }
    }, false);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  
}
