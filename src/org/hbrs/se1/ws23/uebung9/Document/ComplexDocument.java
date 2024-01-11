package org.hbrs.se1.ws23.uebung9.Document;

import java.util.ArrayList;

public class ComplexDocument implements Document{
  private ArrayList<Document> list = new ArrayList<>();

  public void addDocument(Document doc) {
      list.add(doc);
  }
  public boolean removeDocument(Document doc) {
      return list.remove(doc);
  }
  public int getTotalBytes() {
      int totalsize = 0;
      for(Document doc : list) {
          if (doc instanceof ComplexDocument) {
              totalsize += ((ComplexDocument) doc).getTotalBytes();
          } else {
              totalsize += ((CoreDocument) doc).getBytes();
          }
      }
      return totalsize;
  }

}
