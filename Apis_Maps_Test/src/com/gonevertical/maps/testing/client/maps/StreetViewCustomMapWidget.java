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
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewLocation;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaData;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaOptions;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaProvider;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaWidget;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPov;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewTileData;
import com.gonevertical.apis.googlemaps.client.streetview.TileUrlHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/streetview.html}
 */
public class StreetViewCustomMapWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public StreetViewCustomMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Custom Street View"));

    drawStreeView();
   
  }
  
  private void drawStreeView() {
   
    final LatLng position = LatLng.newInstance(21.259758694819777, -157.811758518219);
    
    StreetViewPov pov = StreetViewPov.newInstance();
    pov.setHeading(0);
    pov.setZoom(0);
    pov.setPitch(0);
    
    StreetViewPanoramaOptions options = StreetViewPanoramaOptions.newInstance();
    options.setPosition(position);
    options.setStreeViewPov(pov);
    options.setVisibile(true);
    
    options.setPanoProvider(new StreetViewPanoramaProvider() {
      public StreetViewPanoramaData getPanoData(String pano, int zoom, int tileX, int tileY) {
        
        StreetViewLocation location = StreetViewLocation.newInstance();
        location.setDescription("Diamond Head Lookout");
        location.setLatLng(position);
        location.setPano("diamondheadhike");
        
        Size tileSize = Size.newInstance(300, 300);
        Size worldSize = Size.newInstance(1708, 400);
        
        StreetViewTileData tiles = StreetViewTileData.newInstance();
        tiles.setCenterHeading(0);
        tiles.setTileSize(tileSize);
        tiles.setWorldSize(worldSize);
        tiles.getTileUrl(pano, zoom, tileX, tileY, new TileUrlHandler() {
          public String getTileUrl(String pano, int zoom, int tileX, int tileY) {
            zoom = 0; // TODO make a better tiled pano for testing
            String url = "http://gonevertical-hr.appspot.com/serve?pano=99330&z=" + zoom + "&y=" + tileY + "&x=" + tileX;
            System.out.println(url);
            return url;
          }
        });
        
        StreetViewPanoramaData data = StreetViewPanoramaData.newInstance();
        data.setCopyright("Brandon Donnelson");
        data.setStreetViewLocation(location);
        data.setStreetViewTileData(tiles);
        
        return data;
      }
    });
    
    StreetViewPanoramaWidget wStreet = new StreetViewPanoramaWidget(options);
    pWidget.add(wStreet);
    wStreet.setSize("750px", "500px");
    
    wStreet.setPano("diamondheadhike");
    
  }

  
}
