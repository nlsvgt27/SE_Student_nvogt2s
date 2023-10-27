package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung2.Member.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.ContainerV2.Container;

public class Main {
  public static void main(String[] args) {
    Container c = Container.erstelleContainer();
    for(int i = 0; i < 10; i++) {
      try {
        c.addMember(new ConcreteMember(1000 + i));
      } catch (Exception e) {
        System.out.println("ERROR");
      }
    }

    try {
      c.store();
      c.load();
    } catch (Exception e) {
      System.out.println("Fehler beim speichern");
    }



  }

}
