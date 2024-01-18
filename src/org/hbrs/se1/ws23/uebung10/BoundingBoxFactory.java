package org.hbrs.se1.ws23.uebung10;

public class BoundingBoxFactory {

  public static MyPrettyRectangle createBoundingBox(MyPrettyRectangle[] r) {
    double xmin = Double.MAX_VALUE, ymin = Double.MAX_VALUE, xmax = Double.MIN_VALUE, ymax = Double.MIN_VALUE;
    if (r.length == 0) {
      return new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
    }
    for(int i = 0; i < r.length; i++) {
      if (r[i] == null) {return null;}
      if (r[i].getX1() < xmin) {
        xmin = r[i].getX1();
      }
      if (r[i].getY1() < ymin) {
        ymin = r[i].getY1();
      }
      if (r[i].getX2() > xmax) {
        xmax = r[i].getX2();
      }
      if (r[i].getY2() > ymax) {
        ymax = r[i].getY2();
      }
    }
    return new MyPrettyRectangle(xmin, ymin, xmax, ymax);
  }
}
