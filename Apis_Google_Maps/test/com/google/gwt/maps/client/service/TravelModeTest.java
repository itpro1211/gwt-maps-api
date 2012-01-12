package com.google.gwt.maps.client.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.maps.client.services.Geocoder;
import com.google.gwt.maps.client.services.GeocoderAddressComponent;
import com.google.gwt.maps.client.services.GeocoderGeometry;
import com.google.gwt.maps.client.services.GeocoderLocationType;
import com.google.gwt.maps.client.services.GeocoderRequest;
import com.google.gwt.maps.client.services.GeocoderRequestHandler;
import com.google.gwt.maps.client.services.GeocoderResult;
import com.google.gwt.maps.client.services.GeocoderStatus;
import com.google.gwt.maps.client.services.TravelMode;
import com.google.gwt.maps.client.streetview.StreetViewStatus;

public class TravelModeTest extends GWTTestCase {

  public static final int ASYNC_DELAY_MS = 5000;

  public String getModuleName() {
    return "com.google.gwt.maps.Apis_Google_Maps_ForTests";
  }

  public void testWorks() {
    assertEquals(true, true);
  }

  public void testUse() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.PLACES);   
    LoadApi.go(new Runnable() {
      public void run() {
        TravelMode o = TravelMode.BICYCLING;
        assertEquals("bicycling", TravelMode.BICYCLING.value());
        assertEquals(TravelMode.BICYCLING, TravelMode.fromValue("bicycling"));
        finishTest();
      }
    }, loadLibraries , sensor);
  }

  public void testUse2() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.PLACES);   
    LoadApi.go(new Runnable() {
      public void run() {
        TravelMode o = TravelMode.DRIVING;
        assertEquals("driving", TravelMode.DRIVING.value());
        assertEquals(TravelMode.DRIVING, TravelMode.fromValue("driving"));
        finishTest();
      }
    }, loadLibraries , sensor);
  }

  public void testUse3() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.PLACES);   
    LoadApi.go(new Runnable() {
      public void run() {
        TravelMode o = TravelMode.WALKING;
        assertEquals("walking", TravelMode.WALKING.value());
        assertEquals(TravelMode.WALKING, TravelMode.fromValue("walking"));
        finishTest();
      }
    }, loadLibraries , sensor);
  }
  
}
