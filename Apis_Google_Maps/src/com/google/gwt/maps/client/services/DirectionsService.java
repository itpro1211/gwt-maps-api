package com.google.gwt.maps.client.services;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A service for computing directions between two or more places.
 * {@link http://code.google.com/apis/maps/documentation/javascript/reference.html#DirectionsService}
 */
public class DirectionsService extends JavaScriptObject {
  
  /**
   * use newInstance();
   */
  protected DirectionsService() {}

  /**
   * Creates a new instance of a DirectionsService that sends directions queries to Google servers.
   * @return
   */
  public static final DirectionsService newInstance() {
    return createJso().cast();
  }

  private static final native JavaScriptObject createJso() /*-{
    return new $wnd.google.maps.DirectionsService();
  }-*/;
  
  /**
   * Issue a directions search request.
   * @param request
   * @param handler
   */
  public final native void route(DirectionsRequest request, DirectionsResultHandler handler) /*-{
    var callback = function(result, status) {
      @com.google.gwt.maps.client.services.DirectionsService::routeImpl(Lcom/google/gwt/maps/client/services/DirectionsResult;Ljava/lang/String;Lcom/google/gwt/maps/client/services/DirectionsResultHandler;)(result, status, handler);
    };
    this.route(request, callback);
  }-*/;
  
  private static final void routeImpl(DirectionsResult result, String status, DirectionsResultHandler handler) {
    handler.onCallback(result, DirectionsStatus.fromValue(status));
  }
  
}
