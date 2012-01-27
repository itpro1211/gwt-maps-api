package com.google.gwt.maps.client.workaround;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

public class WorkAroundUtils {

  /**
   * jso carries an objectid in devMode, which needs to be removed.
   * @param jso
   */
  public final static void removeGwtObjectId(JavaScriptObject jso) {
    if (jso == null) {
      return;
    }
    if (!GWT.isScript()) {
      removeGwtObjectIdImpl(jso);
    }
  }
  
  private final static native void removeGwtObjectIdImpl(JavaScriptObject jso) /*-{
    delete jso['__gwt_ObjectId'];
  }-*/;
  
}

