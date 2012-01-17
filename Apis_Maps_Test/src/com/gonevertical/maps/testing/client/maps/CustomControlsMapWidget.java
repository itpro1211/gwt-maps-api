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
import com.google.gwt.maps.client.events.tiles.TilesLoadedMapEvent;
import com.google.gwt.maps.client.events.tiles.TilesLoadedMapHandler;
import com.google.gwt.maps.client.mvc.MVCArray;
import com.google.gwt.maps.client.overlays.InfoWindow;
import com.google.gwt.maps.client.overlays.InfoWindowOptions;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
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
    
//    mapWidget.addTilesLoadedHandler(new TilesLoadedMapHandler() {
//      public void onEvent(TilesLoadedMapEvent event) {
//        drawControls();
//      }
//    });
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
    
    Button button = new Button("B1");
    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        Window.alert("Button 1 Clicked");
      }
    });

    Button button2 = new Button("B2");
    button2.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        Window.alert("Button 2 Clicked ");
      }
    });
    
    final CheckBox cb = new CheckBox();
    cb.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        System.out.println("Button 2 Clicked");
        Window.alert("CheckBox is " + cb.getValue());
      }
    });
    
    FlowPanel widget = new FlowPanel();
    widget.add(button);
    widget.add(new HTML("Custom Controls"));
    widget.add(button);
    widget.add(button2);
    widget.add(cb);
    widget.addStyleName("TestControls");
    
    //TODO I'm not able to get the stylesheet to work.
    // This works below
    DOM.setStyleAttribute(widget.getElement(), "background", "white");
    DOM.setStyleAttribute(widget.getElement(), "padding", "5px");
    DOM.setStyleAttribute(widget.getElement(), "margin", "3px");
    DOM.setStyleAttribute(widget.getElement(), "border", "3px solid #FF0000");
   
    mapWidget.setControls(ControlPosition.RIGHT_CENTER, widget);
    
    
  }

  
  
}
