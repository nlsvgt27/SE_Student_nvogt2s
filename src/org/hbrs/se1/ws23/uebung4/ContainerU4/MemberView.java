package org.hbrs.se1.ws23.uebung4.ContainerU4;

import org.hbrs.se1.ws23.uebung2.Member.Member;

import java.util.List;

public class MemberView {
  public static void dumb(List<Member> list) {
    for (Member m : list) {
      System.out.println(m.toString());
    }
  }
}
