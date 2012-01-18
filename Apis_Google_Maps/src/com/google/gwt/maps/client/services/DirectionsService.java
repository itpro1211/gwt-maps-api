package com.google.gwt.maps.client.services;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

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
  public final native void route(DirectionsRequest request2, DirectionsResultHandler handler) /*-{
    var callback = function(result, status) {
      
      // debug
      //@com.google.gwt.maps.client.services.DirectionsService::test(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("result=", result);
      //@com.google.gwt.maps.client.services.DirectionsService::test(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("status=", status);

      // process callback
      @com.google.gwt.maps.client.services.DirectionsService::routeImpl(Lcom/google/gwt/maps/client/services/DirectionsResult;Ljava/lang/String;Lcom/google/gwt/maps/client/services/DirectionsResultHandler;)(result, status, handler);
    };
    
    //  TODO this works - but the incoming request2 jso, matches exactly yet, won't work, ????
    var request = {
      origin: "Arlington, WA",
      destination: "Seattle, WA",
      travelMode: "DRIVING" // or is $wnd.google.maps.TravelMode.DRIVING
    };
    
    // output the object for debugging
    //@com.google.gwt.maps.client.services.DirectionsService::test(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("request", request);
    //@com.google.gwt.maps.client.services.DirectionsService::test(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("request2=", request2);
    
    this.route(request, callback);
    
  }-*/;
  
  private static final void routeImpl(DirectionsResult result, String status, DirectionsResultHandler handler) {
    handler.onCallback(result, DirectionsStatus.fromValue(status));
  }
  
  public static final void test(String msg, JavaScriptObject jso) {
    JSONObject j = new JSONObject(jso);
    System.out.println("msg= "+ msg + " jso=" + j.toString());
  }
  
 
}
