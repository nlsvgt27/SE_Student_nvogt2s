## Aufgabe 3.2

### CR1:
    Man erstellt ein statisches Objekt der Klasse Container in der Klasse Container selbst.
    Dann hat man eine Methode die den privaten Konstruktor von Container aufruft, falls dieses
    Objekt == null, also noch nicht initialisiert ist. Somit kann nur ein einziges Objekt der Klasse
    erstellt werden.

### Frage: Welches Pattern zur Implementierung und Bereitstellung der Persistenz-Strategien wird hier angewandt?
    Strategy Design Pattern (GoF)
    Strategy-Interface: PersistenceStrategy<E>
    Konkrete Strategy: Die 4 Methoden im Interface
    "Definiere eine Familie von Algorithmen, kapsele jeden einzelnen und mach sie austauschbar. 
    Das Strategiemuster ermöglicht es, den Algorithmus unabhängig von ihn nutzenden Klienten zu variieren."