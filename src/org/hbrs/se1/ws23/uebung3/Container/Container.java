package org.hbrs.se1.ws23.uebung3.Container;

import org.hbrs.se1.ws23.uebung2.Member.Member;
import org.hbrs.se1.ws23.uebung3.persistence.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Container {
  ArrayList<Member> list;
  PersistenceStrategy<Member> strategy;
  //Aufgabe 3.2
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

  public void dumb() {
    for (Member e: list) {
      System.out.println(e.toString());
    }
  }

  //Aufgabe 3.2 weiter
  public void store() throws PersistenceException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\org\\hbrs\\se1\\ws23\\uebung3\\data.txt"))){
      out.writeObject(list);
    } catch (Exception e) {
      throw new PersistenceException(PersistenceException.ExceptionType.NO_FILE_FOUND, "Fehler beim abspeichern");
    }
  }

  public void load() throws PersistenceException {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\org\\hbrs\\se1\\ws23\\uebung3\\data.txt"))){
      list = (ArrayList<Member>) in.readObject();
    } catch (Exception e) {
      throw new PersistenceException(PersistenceException.ExceptionType.NO_FILE_FOUND, "Fehler beim abspeichern");
    }
  }
}
