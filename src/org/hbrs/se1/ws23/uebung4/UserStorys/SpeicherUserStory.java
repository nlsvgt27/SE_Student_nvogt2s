package org.hbrs.se1.ws23.uebung4.UserStorys;


import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategySaveOneByOne;
import org.hbrs.se1.ws23.uebung4.persistenceU4.PersistenceStrategyStream;
import org.hbrs.se1.ws23.uebung4.ContainerU4.*;
import org.hbrs.se1.ws23.uebung4.ContainerU4.Container;

import java.util.Scanner;

public class SpeicherUserStory {
  public static void main (String[] args) throws Exception {
    // ToDo: Bewertung Exception-Handling (F3, F7)
    Container con = Container.erstelleContainer();
    PersistenceStrategy<UserStory> strategy = new PersistenceStrategyStream<>();
    ((PersistenceStrategyStream<UserStory>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung4/test/testdata.ver");
    con.strategy = strategy;
    con.startEingabe();

  }
}
