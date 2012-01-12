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
import com.google.gwt.maps.client.services.DirectionsRendererOptions;
import com.google.gwt.maps.client.services.Geocoder;
import com.google.gwt.maps.client.services.GeocoderAddressComponent;
import com.google.gwt.maps.client.services.GeocoderGeometry;
import com.google.gwt.maps.client.services.GeocoderLocationType;
import com.google.gwt.maps.client.services.GeocoderRequest;
import com.google.gwt.maps.client.services.GeocoderRequestHandler;
import com.google.gwt.maps.client.services.GeocoderResult;
import com.google.gwt.maps.client.services.GeocoderStatus;
import com.google.gwt.maps.client.streetview.StreetViewStatus;

public class DirectionsRendererTest extends GWTTestCase {

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
        DirectionsRendererOptions o = DirectionsRendererOptions.newInstance();
        finishTest();
      }
    }, loadLibraries , sensor);
  }

//  public void testDirections() {
//    boolean sensor = false;
//    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
//    loadLibraries.add(LoadLibrary.PLACES);   
//    LoadApi.go(new Runnable() {
//      public void run() {
//        DirectionsRendererOptions o = DirectionsRendererOptions.newInstance();
//        DirectionsResult left = DirectionsResult.newInstance();
//        a
//        o.setDirections(left);
//        DirectionsResult right = o.getDirections();
//        
//        finishTest();
//      }
//    }, loadLibraries , sensor);
//  }
//  
  
}
