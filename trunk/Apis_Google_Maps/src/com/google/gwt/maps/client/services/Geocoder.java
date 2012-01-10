package com.google.gwt.maps.client.services;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * 
 * {@link }
 */
public class Geocoder extends JavaScriptObject {
  
  /**
   * use newInstance();
   */
  protected Geocoder() {}

  /**
   * 
   * @return
   */
  public static final Geocoder newInstance() {
    return createJso().cast();
  }

  private static final native JavaScriptObject createJso() /*-{
    return new $wnd.google.maps.Geocoder();
  }-*/;
  
  public final native void geocode(GeocoderRequest request, GeocoderRequestHandler handler) /*-{
    var callback = function(results, status) {
      @com.google.gwt.maps.client.services.Geocoder::geocodeImpl(Lcom/google/gwt/core/client/JsArray;Ljava/lang/String;Lcom/google/gwt/maps/client/services/GeocoderRequestHandler;)(results, status, handler);
    };
    this.geocode(request, callback);
  }-*/;
  
  private static final void geocodeImpl(JsArray<GeocoderResult> results, String status, GeocoderRequestHandler handler) {
    handler.onCallback(results, GeocoderStatus.fromValue(status));
  }
  
}
