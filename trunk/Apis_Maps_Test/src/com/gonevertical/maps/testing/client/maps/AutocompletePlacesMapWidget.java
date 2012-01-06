package com.gonevertical.maps.testing.client.maps;

import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.adsense.AdFormat;
import com.gonevertical.apis.googlemaps.client.adsense.AdUnitOptions;
import com.gonevertical.apis.googlemaps.client.adsense.AdUnitWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.LatLngBounds;
import com.gonevertical.apis.googlemaps.client.base.Size;
import com.gonevertical.apis.googlemaps.client.controls.ControlPosition;
import com.gonevertical.apis.googlemaps.client.drawinglib.DrawingControlOptions;
import com.gonevertical.apis.googlemaps.client.drawinglib.DrawingManager;
import com.gonevertical.apis.googlemaps.client.drawinglib.DrawingManagerOptions;
import com.gonevertical.apis.googlemaps.client.drawinglib.OverlayType;
import com.gonevertical.apis.googlemaps.client.events.bounds.BoundsChangeMapEvent;
import com.gonevertical.apis.googlemaps.client.events.bounds.BoundsChangeMapHandler;
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
import com.gonevertical.apis.googlemaps.client.events.place.PlaceChangeMapEvent;
import com.gonevertical.apis.googlemaps.client.events.place.PlaceChangeMapHandler;
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
import com.gonevertical.apis.googlemaps.client.placeslib.Autocomplete;
import com.gonevertical.apis.googlemaps.client.placeslib.AutocompleteOptions;
import com.gonevertical.apis.googlemaps.client.placeslib.AutocompleteType;
import com.gonevertical.apis.googlemaps.client.placeslib.PlaceGeometry;
import com.gonevertical.apis.googlemaps.client.placeslib.PlaceResult;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/layers.html#FusionTables}
 */
public class AutocompletePlacesMapWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  private TextBox tbPlaces;

  public AutocompletePlacesMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();
    
    HTML html = new HTML("<br>Map with autocomplete places &nbsp;&nbsp;");
    tbPlaces = new TextBox();
    tbPlaces.setWidth("350px");
    
    HorizontalPanel hp = new HorizontalPanel();
    hp.add(html);
    hp.add(tbPlaces);
    
    pWidget.add(hp);

    drawMap();

    drawAutoComplete();
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


  private void drawAutoComplete() {

    Element element = tbPlaces.getElement();
    
    AutocompleteType[] types = new AutocompleteType[2];
    types[0] = AutocompleteType.ESTABLISHMENT;
    types[1] = AutocompleteType.GEOCODE;
    
    AutocompleteOptions options = AutocompleteOptions.newInstance();
    options.setTypes(types);
    options.setBounds(mapWidget.getBounds());
    
    final Autocomplete autoComplete = Autocomplete.newInstance(element, options);
    
    autoComplete.addPlaceChangeHandler(new PlaceChangeMapHandler() {
      public void onEvent(PlaceChangeMapEvent event) {        
        
        PlaceResult result = autoComplete.getPlace();
        
        PlaceGeometry geomtry = result.getGeometry();
        LatLng center = geomtry.getLocation();
        
        mapWidget.setCenter(center);
        
        System.out.println("place changed center=" + center);
      }
    });
    
    
    mapWidget.addBoundsChangeHandler(new BoundsChangeMapHandler() {
      public void onEvent(BoundsChangeMapEvent event) {
        LatLngBounds bounds = mapWidget.getBounds();
        autoComplete.setBounds(bounds);
      }
    });
  }



  

}
