package org.hbrs.se1.ws23.uebung10;

public class MyPoint {
  private double x;
  private double y;

  public MyPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }
@Override
  public boolean equals(Object p) {
    if (p instanceof MyPoint) {
      MyPoint punkt = (MyPoint)p;
      return Double.compare(x, punkt.getX()) == 0 & Double.compare(y, punkt.getY()) == 0;
    }
    return false;
  }
}
