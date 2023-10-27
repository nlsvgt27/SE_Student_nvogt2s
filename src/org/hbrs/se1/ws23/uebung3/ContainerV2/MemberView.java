package org.hbrs.se1.ws23.uebung3.ContainerV2;

import java.util.List;
import org.hbrs.se1.ws23.uebung2.Member.Member;

public class MemberView {
  public static void dumb(List<Member> list) {
    for (Member m : list) {
      System.out.println(m.toString());
    }
  }
}
