package org.hbrs.se1.ws23.uebung9.Document;

import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument{
  private String text;
  private Encoding encoding;

  public TextDocument(String text, Encoding enumtype) {
    this.text = text;
    this.encoding = enumtype;
  }
  public int getBytes(){
    try {
      return text.getBytes(encoding.getEncoding()).length;
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return 0;
    }
  }
  public Encoding getEncoding() {
    return encoding;
  }
  public void setEncoding(Encoding encoding) {
    this.encoding = encoding;
  }
}
