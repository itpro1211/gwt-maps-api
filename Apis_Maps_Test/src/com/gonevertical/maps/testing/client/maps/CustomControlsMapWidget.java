package com.gonevertical.maps.testing.client.maps;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.maps.client.MapImpl;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.adsense.AdFormat;
import com.google.gwt.maps.client.adsense.AdUnitOptions;
import com.google.gwt.maps.client.adsense.AdUnitWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.controls.ControlPosition;
import com.google.gwt.maps.client.events.MapEvent;
import com.google.gwt.maps.client.events.MapHandler;
import com.google.gwt.maps.client.events.MapHandlerRegistration;
import com.google.gwt.maps.client.events.MouseEvent;
import com.google.gwt.maps.client.events.channelnumber.ChannelNumberChangeMapEvent;
import com.google.gwt.maps.client.events.channelnumber.ChannelNumberChangeMapHandler;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.events.clickable.ClickableChangeMapEvent;
import com.google.gwt.maps.client.events.clickable.ClickableChangeMapHandler;
import com.google.gwt.maps.client.events.format.FormatChangeMapEvent;
import com.google.gwt.maps.client.events.format.FormatChangeMapHandler;
import com.google.gwt.maps.client.events.mapchange.MapChangeMapEvent;
import com.google.gwt.maps.client.events.mapchange.MapChangeMapHandler;
import com.google.gwt.maps.client.events.position.PositionChangeMapEvent;
import com.google.gwt.maps.client.events.position.PositionChangeMapHandler;
import com.google.gwt.maps.client.mvc.MVCArray;
import com.google.gwt.maps.client.overlays.InfoWindow;
import com.google.gwt.maps.client.overlays.InfoWindowOptions;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * {@link http://code.google.com/apis/maps/documentation/javascript/layers.html#FusionTables}
 */
public class CustomControlsMapWidget extends Composite {

  private VerticalPanel pWidget;

  private MapWidget mapWidget;

  public CustomControlsMapWidget() {
    pWidget = new VerticalPanel();
    initWidget(pWidget);

    draw();
  }

  private void draw() {

    pWidget.clear();

    pWidget.add(new HTML("<br>Custom Controls"));

    drawMap();
    
    drawControls();
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
      }
    });
  }
  
  
  private void drawControls() {
    
    Button button = new Button("test");
    CheckBox cb = new CheckBox();
  
    
    FlowPanel widget = new FlowPanel();
    widget.add(button);
    widget.add(new HTML("test"));
    widget.add(button);
    widget.add(cb);
    
    mapWidget.setControls(ControlPosition.RIGHT_CENTER, widget);
    
    
    JavaScriptObject jso = button.getElement();
    MapHandler<MapEvent> handler = new MapHandler<MapEvent>() {
      public void onEvent(MapEvent event) {
        System.out.println("clicked on button");
      }
    };
    MapHandlerRegistration.addDomListener(jso, ClickEvent.getType(), handler, true);

    
    MapHandler<MapEvent> handler2 = new MapHandler<MapEvent>() {
      public void onEvent(MapEvent event) {
        System.out.println("clicked on checkbox");
      }
    };
    MapHandlerRegistration.addDomListener(cb.getElement(), ClickEvent.getType(), handler2, true);
    
  }

  
  
}
