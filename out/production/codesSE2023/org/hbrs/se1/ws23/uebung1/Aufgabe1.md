## Aufgabe 1.1

### 1)
    a)  Man erstellt eine weiter Klasse "TranslatorFactory" in dem Package "control"
        und erstellt dort durch eine static Methode ein neues Obejekt der Klasse "GermanTranslator".
        Diese wird dann beim Aufruf der Methode zurückgegeben.
        Da die Methode static ist, muss man nun kein Objekt der Klasse "TranslatorFactory"
        erstellen, um diese in "Client" aufzurufen.


    b)  Anwendung des Factory Methode Pattern (Kapitel 6; [GoF])


    c)  Das Interface "Translator" muss damit eine Klasse außerhalb des Packages zugriff auf sie hat,
        auf public umgestellt werden. Somit kann "Client" nun ein Objekt der Klasse "GermanTranslator
        des Interfaces "Translator" erstellen.
### 2)
    a)  Durch Erstellung eines String Arrays kann man die übersetzung Schleifen frei 
        und if-abfragen frei gestalten.

### 3)
    a)  1. Bessere Organisation. 
        2. Isolation der Testumgebung. 
        3. Trennung von Anwendung und Testumgebung. 
        4. Man kann einfacher Tests erstellen die mehrere Teil-Projekte gleichzeitig testen 


    b)  Eine Äquivalenzklasse gibt in einem Blackbox-Test jeweils einen Bereich an, 
        aus dem ich einen Repräsentanten testen muss.


    c)  Der BlackBox-Test ist mit der Klasse Client nicht direkt anwendbar, da die 
        Methode "display(int number)" keinen direkten Rückgabetyp hat und nur was 
        auf der Konsole ausgibt. Somit können wir Werte nicht direkt mit JUnit abgleichen.