package org.hbrs.se1.ws23.uebung9.Document;

public enum Encoding {
  UTF8("UTF-8"),
  UTF16("UTF-16"),
  UTF32("UTF-32");

  private final String encoding;

  Encoding(String encoding) {
    this.encoding = encoding;
  }

  public String getEncoding() {
    return encoding;
  }
}
