package org.hbrs.se1.ws23.uebung4.test;

import org.hbrs.se1.ws23.uebung4.ContainerU4.Container;
import org.hbrs.se1.ws23.uebung4.ContainerU4.ContainerException;
import org.hbrs.se1.ws23.uebung4.UserStorys.UserStory;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceException;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategySaveOneByOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.concurrent.CompletionException;

import static org.junit.jupiter.api.Assertions.*;

public class UserStoryContainerTest {
  @Test
  void testeEnterUndStore() throws Exception {
    System.out.println("Gebe durch /enter/ eine UserStory Ein und speichere sie durch /store/ ab");
    System.out.println("Gebe dann /exit/ ein um das Programm zu verlassen");
    Container con = Container.erstelleContainer();
    PersistenceStrategy<UserStory> strategy = new PersistenceStrategySaveOneByOne<>();
    ((PersistenceStrategySaveOneByOne<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/UserStorys/testdata.ver");
    con.strategy = strategy;
    con.startEingabe();
  }
  @Test
  void testeLoadUndDump() throws Exception {
    System.out.println("Hole durch /load/ eine UserStory und rufe sie durch /dump/ auf");
    System.out.println("Gebe dann /exit/ ein um das Programm zu verlassen");
    Container con = Container.erstelleContainer();
    PersistenceStrategy<UserStory> strategy = new PersistenceStrategySaveOneByOne<>();
    ((PersistenceStrategySaveOneByOne<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/UserStorys/testdata.ver");
    con.strategy = strategy;
    con.startEingabe();
  }

  @Test
  void testeSearch() throws Exception {
    System.out.println("erstelle nun mehrer UserStudys und lass durch den /search/ Befehl dir alle ausgeben, die zu einem Projekt deiner wahl gehören");
    System.out.println("Gebe dann /exit/ ein um das Programm zu verlassen");
    Container con = Container.erstelleContainer();
    PersistenceStrategy<UserStory> strategy = new PersistenceStrategySaveOneByOne<>();
    ((PersistenceStrategySaveOneByOne<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/UserStorys/testdata.ver");
    con.strategy = strategy;
    con.startEingabe();
  }
}
