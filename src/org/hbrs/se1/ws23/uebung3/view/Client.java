package org.hbrs.se1.ws23.uebung3.view;

import org.hbrs.se1.ws23.uebung2.Member.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Member.Member;
import org.hbrs.se1.ws23.uebung3.ContainerV2.Container;
import org.hbrs.se1.ws23.uebung3.ContainerV2.MemberView;

import java.util.ArrayList;

public class Client {
  public static void main(String[] args) {
    Container c = Container.erstelleContainer();
    for(int i = 0; i < 10; i++) {
      try {
        c.addMember(new ConcreteMember(1000 + i));
      } catch (Exception e) {
        System.out.println("ERROR");
      }
    }

    ArrayList<Member> list = (ArrayList<Member>) c.getCurrentList();
    MemberView.dumb(list);


  }
}
