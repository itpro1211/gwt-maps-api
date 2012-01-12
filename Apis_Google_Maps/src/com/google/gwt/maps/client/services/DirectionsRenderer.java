package com.google.gwt.maps.client.services;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.maps.client.mvc.MVCObject;

public class DirectionsRenderer extends MVCObject<DirectionsRenderer> {
  
  protected DirectionsRenderer() {}
  
  public static final DirectionsRenderer newInstance(DirectionsRendererOptions options) {
    return createJso(options).cast();
  }

  private static final native JavaScriptObject createJso(DirectionsRendererOptions options) /*-{
    return new $wnd.google.maps.DirectionsRenderer(options);
  }-*/;
  
  public final native DirectionsResult getDirections() /*-{
    return this.getDirections();
  }-*/;
  
  

}
