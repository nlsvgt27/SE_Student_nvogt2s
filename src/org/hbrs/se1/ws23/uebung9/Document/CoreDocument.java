package org.hbrs.se1.ws23.uebung9.Document;

public abstract class CoreDocument implements Document{
  private int ID;

  public int getID() {
    return ID;
  }
  public void setID(int ID) {
    this.ID = ID;
  }
  public abstract int getBytes();
}
