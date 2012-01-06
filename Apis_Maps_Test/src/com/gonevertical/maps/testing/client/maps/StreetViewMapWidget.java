package com.gonevertical.maps.testing.client.maps;

import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.adsense.AdFormat;
import com.gonevertical.apis.googlemaps.client.adsense.AdUnitOptions;
import com.gonevertical.apis.googlemaps.client.adsense.AdUnitWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.Size;
import com.gonevertical.apis.googlemaps.client.controls.ControlPosition;
import com.gonevertical.apis.googlemaps.client.events.channelnumber.ChannelNumberChangeMapEvent;
import com.gonevertical.apis.googlemaps.client.events.channelnumber.ChannelNumberChangeMapHandler;
import com.gonevertical.apis.googlemaps.client.events.click.ClickMapEvent;
import com.gonevertical.apis.googlemaps.client.events.click.ClickMapHandler;
import com.gonevertical.apis.googlemaps.client.events.format.FormatChangeMapEvent;
import com.gonevertical.apis.googlemaps.client.events.format.FormatChangeMapHandler;
import com.gonevertical.apis.googlemaps.client.events.fusiontablemouse.FusionTablesMouseMapEvent;
import com.gonevertical.apis.googlemaps.client.events.fusiontablemouse.FusionTablesMouseMapHandler;
import com.gonevertical.apis.googlemaps.client.events.kmlmouse.KmlMouseMapEvent;
import com.gonevertical.apis.googlemaps.client.events.kmlmouse.KmlMouseMapHandler;
import com.gonevertical.apis.googlemaps.client.events.mapchange.MapChangeMapEvent;
import com.gonevertical.apis.googlemaps.client.events.mapchange.MapChangeMapHandler;
import com.gonevertical.apis.googlemaps.client.events.panoramiomouse.PanoramioMouseMapEvent;
import com.gonevertical.apis.googlemaps.client.events.panoramiomouse.PanoramioMouseMapHandler;
import com.gonevertical.apis.googlemaps.client.events.position.PositionChangeMapEvent;
import com.gonevertical.apis.googlemaps.client.events.position.PositionChangeMapHandler;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesCell;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesLayer;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesLayerOptions;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesQuery;
import com.gonevertical.apis.googlemaps.client.layers.KmlAuthor;
import com.gonevertical.apis.googlemaps.client.layers.KmlFeatureData;
import com.gonevertical.apis.googlemaps.client.layers.KmlLayer;
import com.gonevertical.apis.googlemaps.client.layers.KmlLayerMetadata;
import com.gonevertical.apis.googlemaps.client.layers.KmlLayerOptions;
import com.gonevertical.apis.googlemaps.client.panoramiolib.PanoramioFeature;
import com.gonevertical.apis.googlemaps.client.panoramiolib.PanoramioLayer;
import com.gonevertical.apis.googlemaps.client.panoramiolib.PanoramioLayerOptions;
import com.gonevertical.apis.googlemaps.client.streeview.StreetViewPanoramaOptions;
import com.gonevertical.apis.googlemaps.client.streeview.StreetViewPanoramaWidget;
import com.gonevertical.apis.googlemaps.client.streeview.StreetViewPov;
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
public class StreetViewMapWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public StreetViewMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Street View"));

    drawStreeView();
   
  }
  
  private void drawStreeView() {
   
    LatLng position = LatLng.newInstance(21.271525, -157.822731);
    
    StreetViewPov pov = StreetViewPov.newInstance();
    pov.setHeading(250);
    pov.setZoom(1);
    pov.setPitch(10);
    
    StreetViewPanoramaOptions options = StreetViewPanoramaOptions.newInstance();
    options.setPosition(position);
    options.setStreeViewPov(pov);
    
    StreetViewPanoramaWidget wStreet = new StreetViewPanoramaWidget(options);
    pWidget.add(wStreet);
    wStreet.setSize("750px", "500px");
  
  }

  
}
