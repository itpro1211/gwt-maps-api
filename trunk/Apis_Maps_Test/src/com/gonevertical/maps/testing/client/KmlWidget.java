package com.gonevertical.maps.testing.client;

import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.Size;
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
public class KmlWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public KmlWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Kml Example - Try clicking on marker"));

    setupMap();

    setLayer();

  }

  private void setupMap() {
    LatLng center = LatLng.newInstance(49.496675,-102.65625);
    MapOptions opts = MapOptions.newInstance();
    opts.setZoom(4);
    opts.setCenter(center);
    opts.setMapTypeId(MapTypeId.ROADMAP);
    
    mapWidget = new MapWidget(opts);
    pWidget.add(mapWidget);
    mapWidget.setSize("500px", "500px");
  }

  private void setLayer() {

    String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
    
    KmlLayer o = KmlLayer.newInstance(url);
    o.setMap(mapWidget);
    
    o.addClickHandler(new KmlMouseMapHandler() {
      public void onEvent(KmlMouseMapEvent event) {
        KmlFeatureData featureData = event.getFeatureData();
        LatLng latlng = event.getLatLng();
        Size size = event.getPixelOffset();
        System.out.println("clicked featureData=" + featureData.getToString());
      }
    });
    
    // TODO I need a better link with more meta data
    KmlLayerMetadata metaData = o.getMetadata();
//    KmlAuthor author = metaData.getAuthor();
//    String authName = author.getName();
//    String authEmail = author.getEmail();
//    String authUri = author.getUri();
//    
//    String desc = metaData.getDescription();
//    String name = metaData.getName();
//    String snippet = metaData.getSnippet();
    
    //System.out.println("work? authName=" + authName);
   
  }

}
