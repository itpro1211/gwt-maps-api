package com.gonevertical.maps.testing.client;

import com.gonevertical.apis.googlemaps.client.MapOptions;
import com.gonevertical.apis.googlemaps.client.MapTypeId;
import com.gonevertical.apis.googlemaps.client.MapWidget;
import com.gonevertical.apis.googlemaps.client.base.LatLng;
import com.gonevertical.apis.googlemaps.client.base.Size;
import com.gonevertical.apis.googlemaps.client.events.fusiontablemouse.FusionTablesMouseMapEvent;
import com.gonevertical.apis.googlemaps.client.events.fusiontablemouse.FusionTablesMouseMapHandler;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesCell;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesLayer;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesLayerOptions;
import com.gonevertical.apis.googlemaps.client.layers.FusionTablesQuery;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/layers.html#FusionTables}
 */
public class FusionTablesWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public FusionTablesWidget() {

    pWidget = new VerticalPanel();

    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("Fusion Tables Example - Try clicking on marker"));

    setupMap();

    setupFusionTablesLayer();

  }

  private void setupMap() {
    // chicago
    LatLng center = LatLng.newInstance(41.898, -87.632);

    MapOptions options = MapOptions.newInstance();
    options.setCenter(center);
    options.setZoom(12);
    options.setMapTypeId(MapTypeId.ROADMAP);

    mapWidget = new MapWidget(options);
    pWidget.add(mapWidget);

    mapWidget.setSize("500px", "500px");
  }

  private void setupFusionTablesLayer() {

    String select = "address";
    String from = "198945";
    String where = "ridership > 5000";

    FusionTablesQuery query = FusionTablesQuery.newInstance();
    query.setSelect(select);
    query.setFrom(from);
    query.setWhere(where);

    FusionTablesLayerOptions options = FusionTablesLayerOptions.newInstance();
    options.setQuery(query);

    FusionTablesLayer layer = FusionTablesLayer.newInstance(options);
    layer.addClickHandler(new FusionTablesMouseMapHandler() {
      public void onEvent(FusionTablesMouseMapEvent event) {
        String infoWindowHtml = event.getInfoWindowHtml();
        LatLng latlng = event.getLatLng();
        Size pixelOffset = event.getPixelOffset();
        JavaScriptObject a = event.getRow();
        String json = event.getRowAsJson();
        System.out.println("click on " + latlng.getToString() + "  json=" + json);
      }
    });
    layer.setMap(mapWidget);
  }

}
