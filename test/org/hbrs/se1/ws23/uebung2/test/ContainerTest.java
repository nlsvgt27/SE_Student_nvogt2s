package org.hbrs.se1.ws23.uebung2.test;

import org.hbrs.se1.ws23.uebung2.Container.Container;
import org.hbrs.se1.ws23.uebung2.Container.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerTest {
  Member member1;
  Member member2;
  Container container;
  @BeforeEach
  void erstelleMember() {
    member1 = new ConcreteMember(1001);
    member2 = new ConcreteMember(1002);
  }
  @BeforeEach
  void erstelleContainer() {
    container = new Container();
  }
  @Test
  void addPositivTest() throws ContainerException{
    container.addMember(member1);
    assertEquals(container.size(), 1);
    container.addMember(member2);
    assertEquals(container.size(), 2);
  }
  @Test
  void addNegativTest() throws ContainerException{
    container.addMember(member1);
    assertThrows(ContainerException.class ,() -> container.addMember(member1));
  }
  @Test
  void deletePositivTest() throws ContainerException{
    container.addMember(member1);
    container.addMember(member2);
    assertEquals(container.deleteMember(1001), "");
    assertEquals(container.size(), 1);
    assertEquals(container.deleteMember(1002), "");
    assertEquals(container.size(), 0);
  }
  @Test
  void deleteNegativTest() throws ContainerException{
    container.addMember(member1);
    container.addMember(member2);
    assertEquals(container.size(), 2);
    assertEquals(container.deleteMember(1003), "Es wurde kein Member mit der von Inhnen gesuchten ID gefunden, und konnte deshalb auch nicht gelöscht werden");
    assertEquals(container.size(), 2);
  }
  @Test
  void testedumb() throws ContainerException {
    container.addMember(member1);
    container.addMember(member2);
    container.dumb();
    //Siehe Konsole


  }
}
