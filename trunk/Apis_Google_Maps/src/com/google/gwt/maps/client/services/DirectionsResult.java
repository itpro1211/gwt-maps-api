package com.google.gwt.maps.client.services;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class DirectionsResult extends JavaScriptObject {

  protected DirectionsResult() {}
  
  public static final DirectionsResult newInstance() {
    return JavaScriptObject.createObject().cast();
  }
  
  public final native void setRoutes(JsArray<DirectionsRoute> routes) /*-{
    this.routes = routes;
  }-*/;
  
  public final native JsArray<DirectionsRoute> getRoutes() /*-{
    return this.routes;
  }-*/;
  
}
