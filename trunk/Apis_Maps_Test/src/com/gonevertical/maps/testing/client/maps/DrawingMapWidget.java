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
import com.gonevertical.apis.googlemaps.client.drawinglib.DrawingControlOptions;
import com.gonevertical.apis.googlemaps.client.drawinglib.DrawingManager;
import com.gonevertical.apis.googlemaps.client.drawinglib.DrawingManagerOptions;
import com.gonevertical.apis.googlemaps.client.drawinglib.OverlayType;
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
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.OverlayCompleteMapEvent;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.OverlayCompleteMapHandler;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.circle.CircleCompleteMapEvent;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.circle.CircleCompleteMapHandler;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.marker.MarkerCompleteMapEvent;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.marker.MarkerCompleteMapHandler;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.polygon.PolygonCompleteMapEvent;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.polygon.PolygonCompleteMapHandler;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.polyline.PolylineCompleteMapEvent;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.polyline.PolylineCompleteMapHandler;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.rectangle.RectangleCompleteMapEvent;
import com.gonevertical.apis.googlemaps.client.events.overlaycomplete.rectangle.RectangleCompleteMapHandler;
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
import com.gonevertical.apis.googlemaps.client.overlays.Circle;
import com.gonevertical.apis.googlemaps.client.overlays.CircleOptions;
import com.gonevertical.apis.googlemaps.client.overlays.Marker;
import com.gonevertical.apis.googlemaps.client.overlays.Polygon;
import com.gonevertical.apis.googlemaps.client.overlays.Polyline;
import com.gonevertical.apis.googlemaps.client.overlays.Rectangle;
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
public class DrawingMapWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public DrawingMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Map with Drawing"));

    drawMap();

    drawDrawing();

    //drawMapAds();
  }

  private void drawMap() {
    LatLng center = LatLng.newInstance(49.496675,-102.65625);
    MapOptions opts = MapOptions.newInstance();
    opts.setZoom(4);
    opts.setCenter(center);
    opts.setMapTypeId(MapTypeId.HYBRID);

    mapWidget = new MapWidget(opts);
    pWidget.add(mapWidget);
    mapWidget.setSize("750px", "500px");

    mapWidget.addClickHandler(new ClickMapHandler() {
      public void onEvent(ClickMapEvent event) {
        // TODO fix the event getting, getting ....
        System.out.println("clicked on latlng=" + event.getMouseEvent().getLatLng());
      }
    });
  }


  private void drawDrawing() {

    DrawingControlOptions drawingControlOptions = DrawingControlOptions.newInstance();
    drawingControlOptions.setPosition(ControlPosition.TOP_CENTER);
    drawingControlOptions.setDrawingModes(OverlayType.values());

    CircleOptions circleOptions = CircleOptions.newInstance();
    //circleOptions.setFillColor("FF6633");

    DrawingManagerOptions options = DrawingManagerOptions.newInstance();
    options.setMap(mapWidget);
    options.setDrawingMode(OverlayType.CIRCLE);
    options.setCircleOptions(circleOptions);

    options.setDrawingControlOptions(drawingControlOptions);

    DrawingManager o = DrawingManager.newInstance(options); 

    o.addCircleCompleteHandler(new CircleCompleteMapHandler() {
      public void onEvent(CircleCompleteMapEvent event) {
        Circle circle = event.getCircle();
        System.out.println("circle completed radius=" + circle.getRadius());
      }
    });

    o.addMarkerCompleteHandler(new MarkerCompleteMapHandler() {
      public void onEvent(MarkerCompleteMapEvent event) {
        Marker marker = event.getMarker();
        System.out.println("marker completed position=" + marker.getPosition());
      }
    });

    o.addOverlayCompleteHandler(new OverlayCompleteMapHandler() {
      public void onEvent(OverlayCompleteMapEvent event) {
        OverlayType ot = event.getOverlayType();
        System.out.println("marker completed OverlayType=" + ot.toString());

        if (ot == OverlayType.CIRCLE) {
          Circle circle = event.getCircle();
          System.out.println("radius=" + circle.getRadius());
        }

        if (ot == OverlayType.MARKER) {
          Marker marker = event.getMarker();
          System.out.println("position=" + marker.getPosition());
        }

        if (ot == OverlayType.POLYGON) {
          Polygon polygon = event.getPolygon();
          System.out.println("paths=" + polygon.getPaths().toString());
        }

        if (ot == OverlayType.POLYLINE) {
          Polyline polyline = event.getPolyline();
          System.out.println("paths=" + polyline.getPath().toString());
        }

        if (ot == OverlayType.RECTANGLE) {
          Rectangle rectangle = event.getRectangle();
          System.out.println("bounds=" + rectangle.getBounds());
        }

        System.out.println("marker completed OverlayType=" + ot.toString());
      }
    });

    o.addPolygonCompleteHandler(new PolygonCompleteMapHandler() {
      public void onEvent(PolygonCompleteMapEvent event) {
        Polygon polygon = event.getPolygon();
        System.out.println("Polygon completed paths=" + polygon.getPath().toString());
      }
    });

    o.addPolylineCompleteHandler(new PolylineCompleteMapHandler() {
      public void onEvent(PolylineCompleteMapEvent event) {
        Polyline polyline = event.getPolyline();
        System.out.println("Polyline completed paths=" + polyline.getPath().toString());
      }
    });

    o.addRectangleCompleteHandler(new RectangleCompleteMapHandler() {
      public void onEvent(RectangleCompleteMapEvent event) {
        Rectangle rectangle = event.getRectangle();
        System.out.println("Rectangle completed bounds=" + rectangle.getBounds().getToString());
      }
    });

  }

  private void drawMapAds() {

    AdUnitOptions options = AdUnitOptions.newInstance();
    options.setFormat(AdFormat.HALF_BANNER);
    options.setPosition(ControlPosition.RIGHT_CENTER);
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
