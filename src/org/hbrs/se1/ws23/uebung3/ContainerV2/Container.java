package org.hbrs.se1.ws23.uebung3.ContainerV2;

import org.hbrs.se1.ws23.uebung3.Member.Member;
import org.hbrs.se1.ws23.uebung3.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Container {
  ArrayList<Member> list;

  //Aufgabe 3.2
  public PersistenceStrategy<Member> strategy;
  //Erstellung eines Statischen Container Objekts in der Klasse selber
  private static Container container;
  private Container() {
    list = new ArrayList<>();
  }
  //Prüfen ob schon ein Objekt existiert. Wenn nicht dann wird ein neues erstellt
  public static Container erstelleContainer() {
    if (container == null) {
      container = new Container();
    }
    return container;
  }
  //--------------------------------------------------------------------------

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

  //Aufgabe 3.2 weiter
  public void store() throws PersistenceException {
    if (strategy == null) {
      throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategie gesetzt");
    }
    strategy.save(list);
  }

  public void load() throws PersistenceException {
    if (strategy == null) {
      throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategie gesetzt");
    }
    list = (ArrayList<Member>) strategy.load();
  }

  public List<Member> getCurrentList() {
    return list;
  }

  //Methode zum Löschen aller Member
  public void deleteAll() {
    while (size() > 0) {
      list.remove(0);
    }
  }
}
