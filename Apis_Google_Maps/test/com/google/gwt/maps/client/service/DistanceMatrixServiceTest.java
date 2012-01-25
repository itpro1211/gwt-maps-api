package com.google.gwt.maps.client.service;

import java.util.ArrayList;

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.services.DistanceMatrixRequest;
import com.google.gwt.maps.client.services.DistanceMatrixRequestHandler;
import com.google.gwt.maps.client.services.DistanceMatrixResponse;
import com.google.gwt.maps.client.services.DistanceMatrixService;
import com.google.gwt.maps.client.services.DistanceMatrixStatus;
import com.google.gwt.maps.client.services.TravelMode;

public class DistanceMatrixServiceTest extends GWTTestCase {

  public static final int ASYNC_DELAY_MS = 5000;

  public String getModuleName() {
    return "com.google.gwt.maps.Apis_Google_Maps_ForTests";
  }

  public void testWorks() {
    assertEquals(true, true);
  }

  public void testUse1() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.PLACES);   
    LoadApi.go(new Runnable() {
      public void run() {
        
//        JsArray<LatLng> origins = ArrayHelper.toJsArray(ao);
//        
//        
//        JsArray<LatLng> destinations = ArrayHelper.toJsArray(ad);
//        
//        DistanceMatrixRequest request = DistanceMatrixRequest.newInstance();
//        request.setOrigins(origins);
//        request.setDestinations(destinations);
//        request.setTravelMode(TravelMode.DRIVING);
//        
//        DistanceMatrixService o = DistanceMatrixService.newInstance();
//        o.getDistanceMatrix(request, new DistanceMatrixRequestHandler() {
//          public void onCallback(DistanceMatrixResponse response, DistanceMatrixStatus status) {
//            
//            // TODO
//            
//            
//          }
//        });
        
        finishTest();
      }
    }, loadLibraries , sensor);
  }

  
}
