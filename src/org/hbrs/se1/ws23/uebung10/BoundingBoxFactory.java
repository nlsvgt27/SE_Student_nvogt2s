package org.hbrs.se1.ws23.uebung10;

public class BoundingBoxFactory {

  public static MyPrettyRectangle createBoundingBox(MyPrettyRectangle[] r) {
    double xmin = 0.0, ymin = 0.0, xmax = 0.0, ymax = 0.0;

    for(int i = 0; i < r.length; i++) {
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
    return new MyPrettyRectangle(xmin, ymin, xmax, xmax);
  }
}
