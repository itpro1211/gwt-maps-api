package com.gonevertical.maps.testing.client;

import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.adsense.AdFormat;
import com.gonevertical.apis.googlemaps.client.adsense.AdUnitOptions;
import com.gonevertical.apis.googlemaps.client.adsense.AdUnitWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.Size;
import com.gonevertical.apis.googlemaps.client.controls.ControlPosition;
import com.gonevertical.apis.googlemaps.client.controls.MapTypeControlOptions;
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
public class ControlsMappingWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public ControlsMappingWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Basic Map Controls Position Example"));

    drawMap();
    
    drawMapAds();
  }

  private void drawMap() {
    
    MapTypeControlOptions controlOptions = MapTypeControlOptions.newInstance();
    controlOptions.setMapTypeIds(MapTypeId.values()); // use all of them
    controlOptions.setPosition(ControlPosition.RIGHT_CENTER);
    
    LatLng center = LatLng.newInstance(49.496675,-102.65625);
    MapOptions options = MapOptions.newInstance();
    options.setZoom(4);
    options.setCenter(center);
    options.setMapTypeId(MapTypeId.HYBRID);
    options.setMapTypeControlOptions(controlOptions);
    
    mapWidget = new MapWidget(options);
    pWidget.add(mapWidget);
    mapWidget.setSize("750px", "500px");
    
    mapWidget.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
        // TODO fix the event getting, getting ....
        System.out.println("clicked on latlng=" + event.getMouseEvent().getLatLng());
      }
    });
  }

  private void drawMapAds() {
    
    AdUnitOptions options = AdUnitOptions.newInstance();
    options.setFormat(AdFormat.LEADERBOARD);
    options.setPosition(ControlPosition.BOTTOM_CENTER);
    options.setMap(mapWidget);
    options.setPublisherId("pub-0032065764310410");
    options.setChannelNumber("4000893900");
    
    AdUnitWidget adUnit = new AdUnitWidget(options);
    
    adUnit.addChannelNumberChangeHandler(new ChannelNumberChangeMapHandler() {
      public void onEvent(ChannelNumberChangeMapEvent event) { 
      }
    });
    
    adUnit.addFormatChangeHandler(new FormatChangeMapHandler() {
      public void onEvent(FormatChangeMapEvent event) {
      }
    });
    
    adUnit.addMapChangeHandler(new MapChangeMapHandler() {
      public void onEvent(MapChangeMapEvent event) {
      }
    });
    
    adUnit.addPositionChangeHandler(new PositionChangeMapHandler() {
      public void onEvent(PositionChangeMapEvent event) {
      }
    });

  }
  
}
