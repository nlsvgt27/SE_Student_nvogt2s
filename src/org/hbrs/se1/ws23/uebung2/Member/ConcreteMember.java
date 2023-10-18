package org.hbrs.se1.ws23.uebung2.Member;

public class ConcreteMember implements Member {
  Integer id;
  public ConcreteMember(Integer id) {
    this.id = id;
  }
  public Integer getID() {
    return this.id;
  }
  public String toString() {
    return "Member (ID = " + id + ")";
  }
}
