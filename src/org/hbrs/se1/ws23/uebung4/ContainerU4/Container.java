package org.hbrs.se1.ws23.uebung4.ContainerU4;

import org.hbrs.se1.ws23.uebung4.UserStorys.UserStory;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceException;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategySaveOneByOne;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategyStream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  public void addUserStory(T obejct) throws ContainerException {
    for (T e: list) {
      if (e.getId() == (obejct.getId())) {
        throw new ContainerException("Das Member-Objekt mit der ID " + obejct.getId() + " ist bereits vorhanden!");
      }
    }
    list.add(obejct);
  }

  public String deleteUserStory(Integer id) {
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
  /*
   * Diese Methode realisiert eine Eingabe ueber einen Scanner
   * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
   * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
   */
  public void startEingabe() throws ContainerException, Exception {
    String strInput = null;
    Scanner scanner = new Scanner( System.in );

    while ( true ) {
      // Ausgabe eines Texts zur Begruessung
      System.out.println("UserStory-Tool V2.0 von Nils Vogt ");

      System.out.print( "> "  );

      strInput = scanner.nextLine();

      // Extrahiert ein Array aus der Eingabe
      String[] strings = strInput.split(" ");

      // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
      if ( strings[0].equals("help") ) {
        help();
      }
      // Auswahl der bisher implementierten Befehle:
      if ( strings[0].equals("dump") ) {
        startAusgabe();
      }
      // Auswahl der bisher implementierten Befehle:
      if ( strings[0].equals("enter") ) {
        enter(scanner);
      }
      if (  strings[0].equals("store")  ) {
        store();
      }
      if ( strings[0].equals("load") ) {
        load();
      }
      if ( strings[0].equals("exit") ) {
        scanner.close();
        break;
      }
      if ( strings[0].equals("search") ) {
        for (T e: list) {
          if(e.getProject().equals(strings[1])) {
            System.out.println(e);
          }
        }
      }
    } // Ende der Schleife

  }

  /**
   * Diese Methode realisiert die Ausgabe.
   */
  public void startAusgabe() {
    list.sort(Comparator.comparing(UserStory::getPrio).reversed());
    for (UserStory u : list) {
      System.out.println(u);
    };
    // [Variante mit forEach-Methode / Streams (--> Kapitel 9, Lösung Übung Nr. 2)?
    //  Gerne auch mit Beachtung der neuen US1
    // (Filterung Projekt = "ein Wert (z.B. Coll@HBRS)" und Risiko >=5
    // Todo: Implementierung Filterung mit Lambda (F5)

  }

  /*
   * Methode zum Speichern der Liste. Es wird die komplette Liste
   * inklusive ihrer gespeicherten UserStory-Objekte gespeichert.
   *
   */

  public void help() {
    System.out.println("Folgende Befehle stehen zur Verfuegung:");
    System.out.println("help: Auflistung aller Befehle");
    System.out.println("dumb: Auflistung aller UserStorys");
    System.out.println("enter: [UserStory] eingabe einer UserStory");
    System.out.println("store: Speicherung der UserStorys");
    System.out.println("load: Laden der bereits gespeicherten UserStorys in das Programm");
    System.out.println("exit: Verlassen des Programms");
    System.out.println("search: Suche nach UserStorys, die zu einem Projekt gehören");
  }

  public void enter(Scanner sc) {
    try {
      System.out.print("UserStoryID: ");
      int id = sc.nextInt();
      sc.nextLine();

      System.out.print("Beschreibung: ");
      String beschreibung = sc.nextLine();

      System.out.print("Akzeptanzkriterium: ");
      String akzeptanzkriterium = sc.nextLine();

      System.out.print("Mehrwert [1...5]: ");
      int mehrwert = sc.nextInt();
      if (mehrwert < 0 || mehrwert > 5) {
        throw new IllegalArgumentException();
      }
      sc.nextLine();

      System.out.print("Strafe [1...5]: ");
      int strafe = sc.nextInt();
      if (strafe < 0 || strafe > 5) {
        throw new IllegalArgumentException();
      }
      sc.nextLine();

      System.out.print("Aufwand [1...n]: ");
      int aufwand = sc.nextInt();
      if (aufwand < 0) {
        throw new IllegalArgumentException();
      }
      sc.nextLine();

      System.out.print("Risk [1...5]: ");
      int risk = sc.nextInt();
      if (risk < 0 || risk > 5) {
        throw new IllegalArgumentException();
      }
      sc.nextLine();

      double prio = (double)((mehrwert + strafe)/(aufwand+risk));
      System.out.print("Project: ");
      String project = sc.nextLine();

      UserStory userStory = new UserStory(id, beschreibung, akzeptanzkriterium, mehrwert, strafe, aufwand, risk, prio);
      userStory.setProject(project);

      addUserStory((T) userStory);
    } catch (ContainerException e) {
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("Eingabe war falsch");
    }

  }

  public static void main (String[] args) throws Exception {
    Container con = Container.erstelleContainer();
    PersistenceStrategy<UserStory> strategy = new PersistenceStrategySaveOneByOne<>();
    ((PersistenceStrategySaveOneByOne<UserStory>)strategy).setLocation("src/org/hbrs/se1/ws23/uebung4/UserStorys/testdata.ver");
    con.strategy = strategy;
    con.startEingabe();
  }
}
