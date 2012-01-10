package com.google.gwt.maps.client.services;

import com.google.gwt.core.client.JsArray;

public interface GeocoderRequestHandler {

  void onCallback(JsArray<GeocoderResult> results, GeocoderStatus status);
  
}
