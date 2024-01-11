package org.hbrs.se1.ws23.uebung9.test;

import org.hbrs.se1.ws23.uebung9.Document.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


public class DocumentTest {
  Document cdoc;
  Document tdoc;
  Document gdoc;

  @BeforeEach
  public void erstelleDocuments() {
    cdoc = new ComplexDocument();
    tdoc = new TextDocument("Helle World", Encoding.UTF8);
    gdoc = new GraficDocument("https:localhost");
    ((ComplexDocument) cdoc).addDocument(tdoc);
    ((ComplexDocument) cdoc).addDocument(gdoc);

    for (int i = 0; i < 10; i++) {
      Document doc1 = new TextDocument("Test" + i, Encoding.UTF16);
      Document doc2 = new TextDocument("Test" + i+100, Encoding.UTF32);
      ((ComplexDocument) cdoc).addDocument(doc1);
      ((ComplexDocument) cdoc).addDocument(doc2);
    }
  }

  @Test
  public void testeBytesMethoden() {
    System.out.println(((CoreDocument) tdoc).getBytes());
    System.out.println(((CoreDocument) gdoc).getBytes());
    System.out.println(((ComplexDocument) cdoc).getTotalBytes());

    ComplexDocument cdoc2 = new ComplexDocument();
    cdoc2.addDocument(cdoc);
    cdoc2.addDocument(cdoc);
    System.out.println(cdoc2.getTotalBytes());

  }

  @Test
  public void testeEncoding() {
    assertEquals(((TextDocument) tdoc).getEncoding(), Encoding.UTF8);
  }
}
