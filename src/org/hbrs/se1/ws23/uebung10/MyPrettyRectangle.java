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
    if (x1 <= r.getX1() & y1 <= r.getY1() & x2 >= r.getX2() & y2 >= r.getY2()) {
      return true;
    }
    return false;
  }
  @Override
  public boolean equals(Object r) {
    if (r instanceof MyPrettyRectangle) {
      MyPrettyRectangle rect = (MyPrettyRectangle) r;
      if (Double.compare(x1, rect.getX1()) == 0  & Double.compare(y1, rect.getY1()) == 0 & Double.compare(x2, rect.getX2()) == 0 & Double.compare(y2, rect.getY2()) == 0) {
        return true;
      }
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
  public double getArea() {
    return (x2 - x1) * (y2 - y1);
  }
  public double getUmfang() {
    return (x2 - x1 + y2 - y1) * 2;
  }

  public static void main(String[] args) {
    MyPrettyRectangle r = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0); // r

    System.out.println(r.getCenter().getX() + " -- " + r.getCenter().getY());
  }
}
