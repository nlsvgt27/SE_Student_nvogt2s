package org.hbrs.se1.ws23.uebung1.control;

public class TranslatorFactory {
  /*
   * Anwendung des Factory Methode Pattern (Kapitel 6; [GoF])
   * Problem: Inkonsistente Objekt-Erzeugung und -Parametererzeugung
   * Lösung: Service-Klasse für die zentrale und konsistente Erzeugung
   */

  public static Translator createGermanTranslator() {
    Translator translator = new GermanTranslator();
    return translator;
  }
}
