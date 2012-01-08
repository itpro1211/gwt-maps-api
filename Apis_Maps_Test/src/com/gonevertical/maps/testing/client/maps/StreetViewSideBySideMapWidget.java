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
import com.gonevertical.apis.googlemaps.client.overlays.Marker;
import com.gonevertical.apis.googlemaps.client.overlays.MarkerOptions;
import com.gonevertical.apis.googlemaps.client.panoramiolib.PanoramioFeature;
import com.gonevertical.apis.googlemaps.client.panoramiolib.PanoramioLayer;
import com.gonevertical.apis.googlemaps.client.panoramiolib.PanoramioLayerOptions;
import com.gonevertical.apis.googlemaps.client.streetview.PanoramaByLocationHandler;
import com.gonevertical.apis.googlemaps.client.streetview.PanoramaIdHandler;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewLocation;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaData;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaOptions;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaProvider;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPanoramaWidget;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewPov;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewService;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewStatus;
import com.gonevertical.apis.googlemaps.client.streetview.StreetViewTileData;
import com.gonevertical.apis.googlemaps.client.streetview.TileUrlHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/streetview.html}
 */
public class StreetViewSideBySideMapWidget extends Composite {

  private VerticalPanel pWidget;

  private HorizontalPanel hp;

  private MapWidget mapWidget;

  private StreetViewPanoramaWidget wStreetPano;

  private StreetViewService service;

  public StreetViewSideBySideMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    setup();
    
    draw();
  }

  private void setup() {
    // setup streetview finding and searching service
    service = StreetViewService.newInstnace();
  }

  /**
   * render the components in the widget
   */
  private void draw() {
    pWidget.clear();

    pWidget.add(new HTML("<br>Street View Demo - click on the map"));

    hp = new HorizontalPanel();
    pWidget.add(hp);

    drawMap();

    drawStreeView();
    
    // allow for things to setup, otherwise getting pano gets null
    Timer t = new Timer() {
      public void run() {
        setupStartingMarker();
      }
    };
    t.schedule(500);
  }

  /**
   * setup the map on the left
   */
  private void drawMap() {
    LatLng berkley = LatLng.newInstance(21.271525, -157.822731);
    MapOptions opts = MapOptions.newInstance();
    opts.setZoom(16);
    opts.setCenter(berkley);
    opts.setMapTypeId(MapTypeId.ROADMAP);

    mapWidget = new MapWidget(opts);
    hp.add(mapWidget);
    mapWidget.setSize("375px", "500px");

    mapWidget.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
        System.out.println("clicked on latlng=" + event.getMouseEvent().getLatLng());
        processClick(event.getMouseEvent().getLatLng());
      }
    });
  }

  /**
   * setup the street view map on the right
   */
  private void drawStreeView() {
    LatLng position = LatLng.newInstance(21.271525, -157.822731);

    StreetViewPov pov = StreetViewPov.newInstance();
    pov.setHeading(250);
    pov.setZoom(1);
    pov.setPitch(10);

    StreetViewPanoramaOptions options = StreetViewPanoramaOptions.newInstance();
    options.setPosition(position);
    options.setStreeViewPov(pov);
    
    wStreetPano = new StreetViewPanoramaWidget(options);
    hp.add(wStreetPano);
    wStreetPano.setSize("375px", "500px");
  }

  private void setupStartingMarker() {
    String pano = wStreetPano.getPano();
    if (pano == null) {
      // TODO hmmmm.... i need a slight delay while everything sets up
      return;
    }
    service.getPanoramaById(pano, new PanoramaIdHandler() {
      public void onCallback(StreetViewPanoramaData data, StreetViewStatus status) {
        LatLng latlng = wStreetPano.getPosition();
        processPanoSearch(latlng, data, status);
      }
    });
  }

  /**
   * get pano data for nearest position
   * @param latlng
   */
  private void processClick(final LatLng latlng) {
    double radius = 50;
    
    service.getPanoramaByLocation(latlng, radius, new PanoramaByLocationHandler() {
      public void onCallback(StreetViewPanoramaData data, StreetViewStatus status) {
        processPanoSearch(latlng, data, status);
      }
    });
  }

  private void processPanoSearch(LatLng latlng, final StreetViewPanoramaData data, StreetViewStatus status) {
    if (status != StreetViewStatus.OK) {
      // TODO error
      return;
    }

    if (data == null) {
      // TODO error
      return;
    }

    // setup marker for location clicked
    MarkerOptions options = MarkerOptions.newInstance();
    options.setClickable(true);
    options.setPosition(latlng);
    options.setMap(mapWidget);
    options.setTitle(data.getLocation().getDescription());

    Marker marker = Marker.newInstance(options);

    // move back on click
    marker.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
        moveStreetView(data);
      }
    });
    
    // move
    moveStreetView(data);
  }

  protected void moveStreetView(StreetViewPanoramaData data) {
    String markerPanoId = data.getLocation().getPano();

    StreetViewPov pov = StreetViewPov.newInstance();
    pov.setHeading(270);
    pov.setPitch(0);
    pov.setZoom(1);

    wStreetPano.setPano(markerPanoId);
    wStreetPano.setPov(pov);
    wStreetPano.setVisible(true);
  }




}
