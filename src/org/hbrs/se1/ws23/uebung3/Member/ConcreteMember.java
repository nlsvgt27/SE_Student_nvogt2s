package org.hbrs.se1.ws23.uebung3.Member;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable{
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
