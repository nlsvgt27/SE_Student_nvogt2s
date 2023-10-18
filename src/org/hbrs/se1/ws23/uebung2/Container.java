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
    for (int i = 0; i < list.size(); i++) {
      if(list.get(i).getID().equals(id)) {
        list.remove(i);
        return "";
      }
    }

    return "Es wurde kein Member mit der von Inhnen gesuchten ID gefunden, und konnte deshalb auch nicht gelöscht werden";
  }

  public void dumb() {
    for (Member e: list) {
      System.out.println(e.toString());
    }
  }

}
