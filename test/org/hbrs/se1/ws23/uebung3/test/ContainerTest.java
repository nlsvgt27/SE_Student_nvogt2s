package org.hbrs.se1.ws23.uebung3.test;

import org.hbrs.se1.ws23.uebung3.ContainerV2.ContainerException;
import org.hbrs.se1.ws23.uebung3.Member.ConcreteMember;
import org.hbrs.se1.ws23.uebung3.Member.Member;
import org.hbrs.se1.ws23.uebung3.ContainerV2.Container;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContainerTest {
  Container c = Container.erstelleContainer();
  @BeforeEach
  void  loescheContainerInhalt() {
    c.deleteAll();
    c.strategy = null;
  }
  @Test
  void noStrategyTest() {
    try {
      c.store();
    } catch (PersistenceException e) {
      assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, e.getExceptionTypeType());
    }
  }

  @Test
  void PersistenceStrategyMongoDBTest() throws ContainerException, PersistenceException{
    c.strategy = new PersistenceStrategyMongoDB<>();

    c.addMember(new ConcreteMember(1000));
    assertEquals(1, c.size());
    assertThrows(ContainerException.class, () -> c.addMember(new ConcreteMember(1000)));
    assertThrows(UnsupportedOperationException.class, () -> c.strategy.openConnection());
    assertThrows(UnsupportedOperationException.class, () -> c.store());
    assertThrows(UnsupportedOperationException.class, () -> c.load());
    assertThrows(UnsupportedOperationException.class, () -> c.strategy.closeConnection());
    c.deleteMember(1000);
    assertEquals(0, c.size());
  }

  @Test
  void wrongFileLocationTest() throws PersistenceException {
    PersistenceStrategy<Member> strategy = new PersistenceStrategyStream<>();
    ((PersistenceStrategyStream<Member>)strategy).setLocation("/");
    c.strategy = strategy;
    try {c.strategy.openConnection();} catch (PersistenceException e) {assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());}
    try {c.store();} catch (PersistenceException e) {assertEquals(PersistenceException.ExceptionType.NO_FILE_FOUND, e.getExceptionTypeType());}
    try {c.load();} catch (PersistenceException e) {assertEquals(PersistenceException.ExceptionType.NO_FILE_FOUND, e.getExceptionTypeType());}
    try {c.strategy.closeConnection();} catch (PersistenceException e) {assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());}
  }

  @Test
  void roundTripTest() throws ContainerException, PersistenceException {
    PersistenceStrategy<Member> strategy = new PersistenceStrategyStream<>();
    ((PersistenceStrategyStream<Member>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung3/test/testdata.ver");
    c.strategy = strategy;
    c.strategy.openConnection();
    for (int i = 0; i < 10; i++) {
      c.addMember(new ConcreteMember(1000 + i));
      assertEquals(i + 1, c.size());
    }
    c.store();
    for (int i = 0; i < 10; i++) {
      c.deleteMember(1000 + i);
      assertEquals(9 - i, c.size());
    }
    c.load();
    assertEquals(10, c.size());
    c.strategy.closeConnection();


  }
}
