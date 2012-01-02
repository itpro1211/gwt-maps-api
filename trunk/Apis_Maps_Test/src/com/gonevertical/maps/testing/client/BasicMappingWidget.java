package com.gonevertical.maps.testing.client;

import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.Size;
import com.gonevertical.apis.googlemaps.client.events.click.ClickMapEvent;
import com.gonevertical.apis.googlemaps.client.events.click.ClickMapHandler;
import com.gonevertical.apis.googlemaps.client.events.fusiontablemouse.FusionTablesMouseMapEvent;
import com.gonevertical.apis.googlemaps.client.events.fusiontablemouse.FusionTablesMouseMapHandler;
import com.gonevertical.apis.googlemaps.client.events.kmlmouse.KmlMouseMapEvent;
import com.gonevertical.apis.googlemaps.client.events.kmlmouse.KmlMouseMapHandler;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesCell;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesLayer;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesLayerOptions;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesQuery;
import com.gonevertical.apis.googlemaps.client.layers.KmlAuthor;
import com.gonevertical.apis.googlemaps.client.layers.KmlFeatureData;
import com.gonevertical.apis.googlemaps.client.layers.KmlLayer;
import com.gonevertical.apis.googlemaps.client.layers.KmlLayerMetadata;
import com.gonevertical.apis.googlemaps.client.layers.KmlLayerOptions;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/layers.html#FusionTables}
 */
public class BasicMappingWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public BasicMappingWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Basic Map Example"));

    setupMap();
  }

  private void setupMap() {
    LatLng center = LatLng.newInstance(49.496675,-102.65625);
    MapOptions opts = MapOptions.newInstance();
    opts.setZoom(4);
    opts.setCenter(center);
    opts.setMapTypeId(MapTypeId.SATELLITE);
    
    mapWidget = new MapWidget(opts);
    pWidget.add(mapWidget);
    mapWidget.setSize("500px", "500px");
    
    mapWidget.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
        // TODO fix the event getting, getting ....
        System.out.println("clicked on latlng=" + event.getMouseEvent().getLatLng());
      }
    });
  }

  
}
