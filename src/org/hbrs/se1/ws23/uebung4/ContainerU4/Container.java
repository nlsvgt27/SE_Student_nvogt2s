package org.hbrs.se1.ws23.uebung4.ContainerU4;

import org.hbrs.se1.ws23.uebung4.UserStorys.UserStory;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceException;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container<T extends UserStory> {
  ArrayList<T> list;
  public PersistenceStrategy<T> strategy;

  //Erstellung eines Statischen Container Objekts in der Klasse selber
  private static Container container;
  private Container() { list = new ArrayList<>(); }
  //Prüfen ob schon ein Objekt existiert. Wenn nicht dann wird ein neues erstellt
  public static Container erstelleContainer() {
    if (container == null) {
      container = new Container();
    }
    return container;
  }

  public int size() {
    return list.size();
  }

  public void addStory(T obejct) throws ContainerException {
    for (T e: list) {
      if (e.getId() == (obejct.getId())) {
        throw new ContainerException("Das Member-Objekt mit der ID " + obejct.getId() + " ist bereits vorhanden!");
      }
    }
    list.add(obejct);
  }

  public String deleteStory(Integer id) {
    for (int i = 0; i < list.size(); i++) {
      if(list.get(i).getId() == (id)) {
        list.remove(i);
        return "";
      }
    }

    return "Es wurde kein Member mit der von Inhnen gesuchten ID gefunden, und konnte deshalb auch nicht gelöscht werden";
  }


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
    list = (ArrayList<T>) strategy.load();
  }

  public List<T> getCurrentList() {
    return list;
  }

  //Methode zum Löschen aller Member
  public void deleteAll() {
    while (size() > 0) {
      list.remove(0);
    }
  }

  public void dumb() {
    List<Integer> newListe2 = new ArrayList<Integer>();
    for ( T p : list ) {
      if (p.getId() > 20 && p.getId()<1000 ) {
        newListe2.add(p.getId());
      }
    }
    System.out.println(newListe2);
  }
}
