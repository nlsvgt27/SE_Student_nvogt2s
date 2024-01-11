package org.hbrs.se1.ws23.uebung9.Document;

public class GraficDocument extends CoreDocument {
  private String URL;
  private final int bytes = 1200;

  public GraficDocument(String URL) {
    this.URL = URL;
  }
  public int getBytes() {
    return bytes;
  }
}
