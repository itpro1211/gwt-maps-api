package com.gonevertical.maps.testing.client;

import java.util.ArrayList;

import com.gonevertical.maps.testing.client.maps.AutocompletePlacesMapWidget;
import com.gonevertical.maps.testing.client.maps.FullPageMapWidget;
import com.gonevertical.maps.testing.client.maps.BasicMapWidget;
import com.gonevertical.maps.testing.client.maps.ControlsMapWidget;
import com.gonevertical.maps.testing.client.maps.DrawingMapWidget;
import com.gonevertical.maps.testing.client.maps.FusionTablesMapWidget;
import com.gonevertical.maps.testing.client.maps.KmlMapWidget;
import com.gonevertical.maps.testing.client.maps.PanoramioMapWidget;
import com.gonevertical.maps.testing.client.maps.StreetViewCustomMapWidget;
import com.gonevertical.maps.testing.client.maps.StreetViewMapWidget;
import com.gonevertical.maps.testing.client.maps.StreetViewSideBySideMapWidget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.controls.ControlPosition;
import com.google.gwt.maps.client.controls.MapTypeControlOptions;
import com.google.gwt.maps.client.events.MouseEvent;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * Super raw source!
 * 
 */
public class Apis_Maps_Test_FullPage implements EntryPoint {

  public void onModuleLoad() {
    loadMapApi();
  }
 
  private void loadMapApi() {
    boolean sensor = true;
    
    // load all the libs for use
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.ADSENSE);
    loadLibraries.add(LoadLibrary.DRAWING);
    loadLibraries.add(LoadLibrary.GEOMETRY);
    loadLibraries.add(LoadLibrary.PANORAMIO);
    loadLibraries.add(LoadLibrary.PLACES);
    
    Runnable onLoad = new Runnable() {
      public void run() {
        draw();
      }
    };
    
    LoadApi.go(onLoad, loadLibraries, sensor);
  }

  
  private void draw() {
    
    FullPageMapWidget wMap = new FullPageMapWidget();
    RootPanel.get().add(wMap);
    
  }
  
}
