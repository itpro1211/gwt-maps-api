package com.gonevertical.maps.testing.client;

import java.math.BigDecimal;

import com.gonevertical.apis.googlemaps.client.LoadApi;
import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.LatLngBounds;
import com.gonevertical.apis.googlemaps.client.base.Point;
import com.gonevertical.apis.googlemaps.client.controls.ControlPosition;
import com.gonevertical.apis.googlemaps.client.controls.MapTypeControlOptions;
import com.gonevertical.apis.googlemaps.client.controls.MapTypeStyle;
import com.gonevertical.apis.googlemaps.client.controls.ZoomControlOptions;
import com.gonevertical.apis.googlemaps.client.events.MouseEvent;
import com.gonevertical.apis.googlemaps.client.events.click.ClickMapEvent;
import com.gonevertical.apis.googlemaps.client.events.click.ClickMapHandler;
import com.gonevertical.apis.googlemaps.client.maptypes.MapTypeStyleFeatureType;
import com.gonevertical.apis.googlemaps.client.maptypes.Projection;
import com.gonevertical.apis.googlemaps.client.overlays.Marker;
import com.gonevertical.apis.googlemaps.client.overlays.MarkerOptions;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * Super raw source!
 * 
 */
public class Apis_Maps_Test implements EntryPoint {

  public void onModuleLoad() {
    loadMapApi();
  }
 
  private void loadMapApi() {
    Runnable onLoad = new Runnable() {
      public void run() {
        draw();
      }
    };
    boolean sensor = true;
    LoadApi.go(onLoad, sensor);
  }

  
  private void draw() {

    drawMap();
    
    drawFusionMap();
    
  }

  private void drawMap() {
    MapOptions options = MapOptions.newInstance();
    MapWidget wMap = new MapWidget(options);
    RootPanel.get().add(wMap);
    
    wMap.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
        MouseEvent me = event.getMouseEvent();
        LatLng ll = me.getLatLng();
        Window.alert("clicked on map: " + ll.getToString());
      }
    });

    LatLng position = LatLng.newInstance(19.54, -155.43);
    MarkerOptions optionsMarker = MarkerOptions.newInstance();
    optionsMarker.setPosition(position);
    Marker marker = Marker.newInstance(optionsMarker);
    marker.setMap(wMap);
    
    wMap.setSize("500px", "500px");
    wMap.addStyleName("test1");
  }
  
 
  private void drawFusionMap() {
    FusionTablesWidget wMap = new FusionTablesWidget();
    RootPanel.get().add(wMap);
  }
  
  private void drawTestMap() {
    
    MapTypeControlOptions mapTypeControlOptions = MapTypeControlOptions.newInstance();
    mapTypeControlOptions.setControlPosition(ControlPosition.BOTTOM_RIGHT);
    mapTypeControlOptions.setMapTypeIds(MapTypeId.values());
    
    MapOptions options = MapOptions.newInstance();
    options.setBackgroundColor("#FFD300"); // works
    options.setDisableDefaultUi(false);
    options.setDisableDoubleClickZoom(true); // works
    options.setDraggable(true); // true
    options.setDraggingCursor(true);
    options.setHeading(45);
    options.setKeyboardShortcuts(true); // works
    options.setMapTypeControl(true); 
    
    options.setMapTypeControlOptions(mapTypeControlOptions);
    
    FlowPanel fp = new FlowPanel();
    RootPanel.get().add(fp);
    fp.setSize("500px", "500px");
    fp.addStyleName("test2");
    testMap(fp.getElement(), options);
  }
  
  private static native JavaScriptObject testMap(Element element, MapOptions options) /*-{
    
    //var myOptions = {
    //  zoom: 6,
    //  center: myLatLng,
    //  mapTypeId: $wnd.google.maps.MapTypeId[mapType]
    //};
    
    var map = new $wnd.google.maps.Map(element, options);
    
    return map;
  }-*/;
  
  
  private void test1() {
    
    
    System.out.println("loaded");
  }
  

  private final native int test2(String type) /*-{
    //alert(type);
    var test = eval("$wnd.google.maps.ControlPosition." + type);
    return test;
  }-*/;
  
}
