package com.google.gwt.maps.client.geometrylib;

import java.util.ArrayList;

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.geometrylib.SphericalUtils;
import com.google.gwt.maps.client.mvc.MVCArray;

public class SphericalUtilsTest extends GWTTestCase {

  public static final int ASYNC_DELAY_MS = 5000;

  public String getModuleName() {
    return "com.google.gwt.maps.Apis_Google_Maps_ForTests";
  }

  public void testWorks() {
    assertEquals(true, true);
  }

  public void testComputeArea1() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> loop = ArrayHelper.toJsArray(array);
        int area = SphericalUtils.computeArea(loop);
        assertEquals(200655538, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }

  public void testComputeArea2() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        MVCArray<LatLng> loop = MVCArray.newInstance(path);        
        int area = SphericalUtils.computeArea(loop);
        assertEquals(200655538, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }

  public void testComputeArea1_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> loop = ArrayHelper.toJsArray(array);
        int area = SphericalUtils.computeArea(loop, 2006);
        assertEquals(19, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }

  public void testComputeArea2_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        MVCArray<LatLng> loop = MVCArray.newInstance(path);        
        int area = SphericalUtils.computeArea(loop, 2006);
        assertEquals(19, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeDistance() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng from = LatLng.newInstance(49.496675,-102.65625);
        LatLng to = LatLng.newInstance(50.496675,-103.65625);
        int distance = SphericalUtils.computeDistanceBetween(from, to);
        assertEquals(132333, distance);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeDistanceRadius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng from = LatLng.newInstance(49.496675,-102.65625);
        LatLng to = LatLng.newInstance(50.496675,-103.65625);
        int distance = SphericalUtils.computeDistanceBetween(from, to, 2006);
        assertEquals(41, distance);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeHeading() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng from = LatLng.newInstance(49.496675,-102.65625);
        LatLng to = LatLng.newInstance(50.496675,-103.65625);
        int heading = SphericalUtils.computeHeading(from, to);
        assertEquals(-32, heading);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeLength() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        int length = SphericalUtils.computeLength(path);
        assertEquals(263861, length);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeLength2() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        MVCArray<LatLng> path2 = MVCArray.newInstance(path);       
        int length = SphericalUtils.computeLength(path2);
        assertEquals(263861, length);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeLength_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        int length = SphericalUtils.computeLength(path, 2006);
        assertEquals(82, length);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeLength2_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        MVCArray<LatLng> path2 = MVCArray.newInstance(path);       
        int length = SphericalUtils.computeLength(path2, 2006);
        assertEquals(82, length);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeOffset() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng from = LatLng.newInstance(49.496675,-102.65625);
        LatLng to = LatLng.newInstance(50.496675,-103.65625);
        int distance = 2006;
        int heading = 45;
        LatLng offset = SphericalUtils.computeOffset(from, distance, heading);
        assertEquals("(49.50941554956089, -102.63662616512198)", offset.getToString());
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeOffset_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);
    LoadApi.go(new Runnable() {
      public void run() {
        LatLng from = LatLng.newInstance(49.496675,-102.65625);
        LatLng to = LatLng.newInstance(50.496675,-103.65625);
        int distance = 2006;
        int heading = 45;
        LatLng offset = SphericalUtils.computeOffset(from, distance, heading, 2006);
        assertEquals("(52.87142257631697, -2.9751884784654976)", offset.getToString());
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }

  public void testComputeSignedArea1() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> loop = ArrayHelper.toJsArray(array);
        int area = SphericalUtils.computeSignedArea(loop);
        assertEquals(-200655538, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }

  public void testComputeSignedArea2() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        MVCArray<LatLng> loop = MVCArray.newInstance(path);        
        int area = SphericalUtils.computeSignedArea(loop);
        assertEquals(-200655538, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testComputeSignedArea1_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> loop = ArrayHelper.toJsArray(array);
        int area = SphericalUtils.computeSignedArea(loop, 2006);
        assertEquals(-19, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }

  public void testComputeSignedArea2_radius() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng[] array = new LatLng[3];
        array[0] = LatLng.newInstance(49.496675,-102.65625);
        array[1] = LatLng.newInstance(50.496675,-103.65625);
        array[2] = LatLng.newInstance(51.496675,-104.65625);
        JsArray<LatLng> path = ArrayHelper.toJsArray(array);
        MVCArray<LatLng> loop = MVCArray.newInstance(path);        
        int area = SphericalUtils.computeSignedArea(loop, 2006);
        assertEquals(-19, area);
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
  public void testInterpolate() {
    boolean sensor = false;
    ArrayList<LoadLibrary> loadLibraries = new ArrayList<LoadApi.LoadLibrary>();
    loadLibraries.add(LoadLibrary.GEOMETRY);

    LoadApi.go(new Runnable() {
      public void run() {
        LatLng from = LatLng.newInstance(49.496675,-102.65625);
        LatLng to = LatLng.newInstance(50.496675,-103.65625);
        LatLng ll = SphericalUtils.interpolate(from, to, .50d);
        assertEquals("(49.99774917449739, -103.15105034281981)", ll.getToString());
        finishTest();
      }
    }, loadLibraries, sensor);
    delayTestFinish(ASYNC_DELAY_MS);
  }
  
}

