package org.hbrs.se1.ws23.uebung10;

public class MyPrettyRectangle {

  private double x1, y1, x2, y2;

  public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public boolean contains(MyPrettyRectangle r) {
    if (x1 < r.getX1() & y1 < r.getY1() & x2 > r.getX2() & y2 > r.getY2()) {
      return true;
    }
    return false;
  }

  public double getX1() {
    return x1;
  }
  public double getY1() {
    return y1;
  }
  public double getX2() {
    return x2;
  }
  public double getY2() {
    return y2;
  }

  public MyPoint getCenter() {
    double x = (x1 + x2) / 2;
    double y = (y1 + y2) / 2;

    return new MyPoint(x, y);
  }
}
