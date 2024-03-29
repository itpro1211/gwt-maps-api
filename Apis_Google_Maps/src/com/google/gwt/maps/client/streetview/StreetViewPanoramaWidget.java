package com.google.gwt.maps.client.streetview;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.closeclick.CloseClickMapHandler;
import com.google.gwt.maps.client.events.links.LinksChangeMapHandler;
import com.google.gwt.maps.client.events.pano.PanoChangeMapHandler;
import com.google.gwt.maps.client.events.position.PositionChangeMapHandler;
import com.google.gwt.maps.client.events.pov.PovChangeMapHandler;
import com.google.gwt.maps.client.events.resize.ResizeMapHandler;
import com.google.gwt.maps.client.events.visible.VisibleChangeMapHandler;
import com.google.gwt.maps.client.mvc.MVCArray;
import com.google.gwt.maps.client.mvc.MVCObjectWidget;
import com.google.gwt.user.client.DOM;

/**
 * Displays the panorama for a given LatLng or panorama ID. A StreetViewPanorama object provides a Street View "viewer" which can be stand-alone within a separate <div> or bound to a Map. This class extends MVCObject.
 * {@linkhttp://code.google.com/apis/maps/documentation/javascript/reference.html#StreetViewPanorama} 
 */
public class StreetViewPanoramaWidget extends MVCObjectWidget<StreetViewPanoramaImpl> {
  
  private StreetViewPanoramaImpl impl;

  /**
   * create widget from a previous jso implementation
   * @param impl
   * @return
   */
  public static StreetViewPanoramaWidget newInstance(StreetViewPanoramaImpl impl) {
    return new StreetViewPanoramaWidget(impl);
  }
  
  /**
   * Displays the panorama for a given LatLng or panorama ID. A StreetViewPanorama object provides a Street View "viewer" which can be stand-alone within a separate <div> or bound to a Map. This class extends MVCObject.
   */
  public StreetViewPanoramaWidget(StreetViewPanoramaOptions options) {
    Element div = DOM.createDiv();
    setElement(div);
    impl = StreetViewPanoramaImpl.newInstance(div, options);
    setStyleName("gwt-map-StreetViewPanoramaWidget-div");
  }
  
  /**
   * create a widget from a previous jso implementation
   * @param impl
   */
  private StreetViewPanoramaWidget(StreetViewPanoramaImpl impl) {
    this.impl = impl;
    Element div = DOM.createDiv(); // setup a new div only option.
    setElement(div);
    setStyleName("gwt-map-StreetViewPanoramaWidget-div");
  }
  
  /**
   * get the JavaScriptObject overlay
   * @return
   */
  public StreetViewPanoramaImpl getJso() {
    return impl;
  };

  /**
   * Returns the set of navigation links for the Street View panorama.
   * @return
   */
  public JsArray<StreetViewLink> getLinks() {
    return impl.getLinks();
  };
  
  /**
   * Returns the current panorama ID for the Street View panorama. This id is stable within the browser's current session only.
   * @return
   */
  public String getPano() {
    return impl.getPano();
  };
  
  /**
   * Returns the current LatLng position for the Street View panorama.
   * @return
   */
  public LatLng getPosition() {
    return impl.getPosition();
  };
  
  /**
   * Returns the current point of view for the Street View panorama.
   * @return
   */
  public StreetViewPov getPov() {
    return impl.getPov();
  };
  
  /**
   * Returns true if the panorama is visible. It does not specify whether Street View imagery is available at the specified position.
   * @return
   */
  public boolean getVisible() {
    return impl.getVisible();
  };
  
  /**
   * Set the custom panorama provider called on pano change to load custom panoramas.
   * @param provider
   */
  public void registerPanoProvider(StreetViewPanoramaProvider provider) {
    impl.registerPanoProvider(provider);
  };
  
  /**
   * Sets the current panorama ID for the Street View panorama.
   * @param pano
   */
  public void setPano(String pano) {
    impl.setPano(pano);
  };
  
  /**
   * Sets the current LatLng position for the Street View panorama.
   * @param latLng
   */
  public void setPosition(LatLng latlng) {
    impl.setPosition(latlng);
  };
  
  /**
   * Sets the point of view for the Street View panorama.
   * @param pov
   */
  public void setPov(StreetViewPov pov) {
    impl.setPov(pov);
  };
  
  /**
   * Sets to true to make the panorama visible. If set to false, the panorama will be hidden whether it is embedded in the map or in its own <div>.
   * @param visible
   */
  public void setVisible(boolean visible) {
    impl.setVisible(visible);
  };
  
  
  
  
  /**
   * TODO
   * Additional controls to attach to the panorama. To add a control to the panorama, add the control's <div> to the MVCArray corresponding to the ControlPosition where it should be rendered.
   * @param controls
   */
  public void setControls(MVCArray<Element> controls) { 
    //    impl.controls = controls; //TODO
  }





  /**
   * This event is fired when the close button is clicked.
   * @param handler
   * @return
   */
  public HandlerRegistration addCloseClickHandler(CloseClickMapHandler handler) {
    return impl.addCloseClickHandler(handler);
  }
  
  /**
   * This event is fired when the panorama's links change. The links change asynchronously following a pano id change.
   * @param handler
   * @return
   */
  public HandlerRegistration addLinksChangeHandler(LinksChangeMapHandler handler) {
    return impl.addLinksChangeHandler(handler);
  }
 
  /**
   * This event is fired when the panorama's pano id changes. The pano may change as the user navigates through the panorama or the position is manually set. Note that not all position changes trigger a pano_changed.
   * @param handler
   * @return
   */
  public HandlerRegistration addPanoChangeHandler(PanoChangeMapHandler handler) {
    return impl.addPanoChangeHandler(handler);
  }
  
  /**
   * This event is fired when the panorama's position changes. The position changes as the user navigates through the panorama or the position is set manually.
   * @param handler
   * @return
   */
  public HandlerRegistration addPositionChangeHandler(PositionChangeMapHandler handler) {
    return impl.addPositionChangeHandler(handler);
  }
  
  /**
   * This event is fired when the panorama's point-of-view changes. The point of view changes as the pitch, zoom, or heading changes.
   * @param handler
   * @return
   */
  public HandlerRegistration addPovChangeHandler(PovChangeMapHandler handler) {
    return impl.addPovChangeHandler(handler);
  }
  
  /**
   * Developers should trigger this event on the panorama when its div changes size: google.maps.event.trigger(panorama, 'resize').
   * @param handler
   * @return
   */
  public HandlerRegistration addResizeHandler(ResizeMapHandler handler) {
    return impl.addResizeHandler(handler);
  }
  
  /**
   * This event is fired when the panorama's visibility changes. The visibility is changed when the Pegman id dragged onto the map, the close button is clicked, or setVisible() is called.
   * @param handler
   * @return
   */
  public HandlerRegistration addVisibleChangeHandler(VisibleChangeMapHandler handler) {
    return impl.addVisibleChangeHandler(handler);
  }
}
