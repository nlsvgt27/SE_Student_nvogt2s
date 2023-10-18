package org.hbrs.se1.ws23.uebung2;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Container {
  ArrayList<Member> list = new ArrayList<>();

  public int size() {
    return list.size();
  }

  public void addMember(Member member) throws ContainerException {
    for (Member e: list) {
      if (e.getID().equals(member.getID())) {
        throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
      }
    }
    list.add(member);
  }

  public String deleteMember(Integer id) {
    String ergebnis = "";
    return ergebnis;
  }

}
