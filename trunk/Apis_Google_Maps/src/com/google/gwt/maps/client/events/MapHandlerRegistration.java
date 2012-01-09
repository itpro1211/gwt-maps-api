package com.google.gwt.maps.client.events;

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.ajaxloader.client.Properties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.maps.client.MapWidget;

public class MapHandlerRegistration {

  public static <E extends MapEvent> HandlerRegistration addHandler(JavaScriptObject jso, MapEventType eventType, MapHandler<E> handler, MapEventFormatter<E> formatter) {
    final JavaScriptObject listener = addHandlerImpl(jso, eventType.value(), handler, formatter);
    HandlerRegistration registration = new HandlerRegistration() {
      public void removeHandler() { 
        removeHandlerImpl(listener);
      }
    };
    return registration;
  }
  
  public static <E extends MapEvent> HandlerRegistration addHandlerMvc(JavaScriptObject jso, MapEventType eventType, MapHandler<E> handler, MapEventFormatter<E> formatter) {
    final JavaScriptObject listener = addHandlerImplMvc(jso, eventType.value(), handler, formatter);
    HandlerRegistration registration = new HandlerRegistration() {
      public void removeHandler() { 
        removeHandlerImpl(listener);
      }
    };
    return registration;
  }
  
  public static <E extends MapEvent> HandlerRegistration addHandlerDrawing(JavaScriptObject jso, MapEventType eventType, MapHandler<E> handler, MapEventFormatter<E> formatter) {
    final JavaScriptObject listener = addHandlerImplDrawing(jso, eventType.value(), handler, formatter);
    HandlerRegistration registration = new HandlerRegistration() {
      public void removeHandler() { 
        removeHandlerImpl(listener);
      }
    };
    return registration;
  } 
  
  

  private static native <E extends MapEvent> JavaScriptObject addHandlerImpl(JavaScriptObject jso, String eventName, MapHandler<E> handler, MapEventFormatter<E> formatter) /*-{
    var callback = function(event) { 
      @com.google.gwt.maps.client.events.MapHandlerRegistration::onCallback(Lcom/google/gwt/maps/client/events/MapHandler;Lcom/google/gwt/ajaxloader/client/Properties;Lcom/google/gwt/maps/client/events/MapEventFormatter;)(handler, event, formatter);
    };          
    return $wnd.google.maps.event.addListener(jso, eventName, callback)
  }-*/;
  
  private static native <E extends MapEvent> JavaScriptObject addHandlerImplMvc(JavaScriptObject jso, String eventName, MapHandler<E> handler, MapEventFormatter<E> formatter) /*-{
    var callback = function(event) { 
      var eventCon = {
        index: event
      };
      @com.google.gwt.maps.client.events.MapHandlerRegistration::onCallback(Lcom/google/gwt/maps/client/events/MapHandler;Lcom/google/gwt/ajaxloader/client/Properties;Lcom/google/gwt/maps/client/events/MapEventFormatter;)(handler, eventCon, formatter);
    };          
    return $wnd.google.maps.event.addListener(jso, eventName, callback)
  }-*/;
  
  /**
   * drawing sends events partly with different signature or arguments.
   * @param jso
   * @param eventName
   * @param handler
   * @param formatter
   * @return
   */
  private static native <E extends MapEvent> JavaScriptObject addHandlerImplDrawing(JavaScriptObject jso, String eventName, MapHandler<E> handler, MapEventFormatter<E> formatter) /*-{
    var callback = function(event) { 
      var eventCon = {
        overlay: event
      };
      @com.google.gwt.maps.client.events.MapHandlerRegistration::onCallback(Lcom/google/gwt/maps/client/events/MapHandler;Lcom/google/gwt/ajaxloader/client/Properties;Lcom/google/gwt/maps/client/events/MapEventFormatter;)(handler, eventCon, formatter);
    };          
    return $wnd.google.maps.event.addListener(jso, eventName, callback)
  }-*/;

  /**
   * HandlerRegistration call when finished
   * @param listener
   */
  private static native void removeHandlerImpl(JavaScriptObject listener) /*-{
    $wnd.google.maps.MapsEventListener.addListener(listener);
  }-*/;

  /**
   * process generic handler callback
   * @param handler
   * @param properties
   * @param formatter
   */
  @SuppressWarnings("unused")
  protected static <E extends MapEvent> void onCallback(final MapHandler<E> handler, final Properties properties, final MapEventFormatter<E> formatter) {
    try {
      formatEvent(handler, properties, formatter);
    } catch (Throwable x) {
      GWT.getUncaughtExceptionHandler().onUncaughtException(x);
    }
  }

  /**
   * create a map event
   * @param handler
   * @param properties
   * @param formatter
   */
  private static <E extends MapEvent> void formatEvent(MapHandler<E> handler, Properties properties,  MapEventFormatter<E> formatter) {
    E event = formatter.createEvent(properties);
    handler.onEvent(event);
  }

  /**
   * Triggers the given event. All arguments after eventName are passed as arguments to the listeners.
   * 
   * fyi: use Marker in objects to click on
   *  
   * @param w
   * @param eventType
   * @param args
   */
  public static void trigger(MapWidget w, MapEventType eventType, JavaScriptObject...objects) {
    JsArray<JavaScriptObject> a = ArrayHelper.toJsArray(objects);
    triggerImpl(w, eventType.value(), a);
  }

  private static native void triggerImpl(MapWidget w, String eventName, JsArray<JavaScriptObject> args) /*-{
    var jso = w.@com.google.gwt.maps.client.MapWidget::getJso()();
    $wnd.google.maps.event.trigger(jso, eventName, args);
  }-*/;

}
