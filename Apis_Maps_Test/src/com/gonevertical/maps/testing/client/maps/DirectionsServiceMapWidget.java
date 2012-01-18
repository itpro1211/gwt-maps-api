package com.gonevertical.maps.testing.client.maps;

import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.services.DirectionsRenderer;
import com.google.gwt.maps.client.services.DirectionsRendererOptions;
import com.google.gwt.maps.client.services.DirectionsRequest;
import com.google.gwt.maps.client.services.DirectionsResult;
import com.google.gwt.maps.client.services.DirectionsResultHandler;
import com.google.gwt.maps.client.services.DirectionsService;
import com.google.gwt.maps.client.services.DirectionsStatus;
import com.google.gwt.maps.client.services.TravelMode;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/layers.html#FusionTables}
 */
public class DirectionsServiceMapWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public DirectionsServiceMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Directions Service"));

    drawMap();
    
    drawDirections();
  }
  
  private void drawMap() {
    LatLng center = LatLng.newInstance(48.11, -123.24);
    MapOptions opts = MapOptions.newInstance();
    opts.setZoom(8);
    opts.setCenter(center);
    opts.setMapTypeId(MapTypeId.HYBRID);
    
    mapWidget = new MapWidget(opts);
    pWidget.add(mapWidget);
    mapWidget.setSize("750px", "500px");
    
    mapWidget.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
      }
    });
  }
  
  private void drawDirections() {
    
    DirectionsRendererOptions options = DirectionsRendererOptions.newInstance();
    final DirectionsRenderer directionsDisplay = DirectionsRenderer.newInstance(options);
    directionsDisplay.setMap(mapWidget);
    
    //LatLng origin = LatLng.newInstance(37.7699298, -122.4469157);
    //LatLng destination = LatLng.newInstance(37.7683909618184, -122.51089453697205);
    
    String origin = "Arlington, WA";
    String destination = "Seattle, WA";
    
    DirectionsRequest request = DirectionsRequest.newInstance();
    request.setOrigin(origin);
    request.setDestination(destination);
    request.setTravelMode(TravelMode.DRIVING);
    
    DirectionsService o = DirectionsService.newInstance();
    o.route(request, new DirectionsResultHandler() {
      public void onCallback(DirectionsResult result, DirectionsStatus status) {
        if (status == DirectionsStatus.OK) {
          directionsDisplay.setDirections(result);
          
        } else if (status == DirectionsStatus.INVALID_REQUEST) {
     
        } else if (status == DirectionsStatus.MAX_WAYPOINTS_EXCEEDED) {
     
        } else if (status == DirectionsStatus.NOT_FOUND) {
     
        } else if (status == DirectionsStatus.OVER_QUERY_LIMIT) {
     
        } else if (status == DirectionsStatus.REQUEST_DENIED) {
     
        } else if (status == DirectionsStatus.UNKNOWN_ERROR) {
     
        } else if (status == DirectionsStatus.ZERO_RESULTS) {
          
        }
      
      }
    });
    
  }
  
}
