# Anleitung: Demo vorführen und anpassen

Diese Anleitung erklärt dir Schritt für Schritt, wie du die **Redesign 2 (Strategy Pattern)** Demo startest, erklärst und live im Code anpasst.

## 1. Demo starten (Auslösen)

Um die Demo auszuführen, musst du den Code kompilieren und dann die Klasse `AppRedesign2` starten.

**Schritt 1:** Öffne das Terminal in VS Code (unten).

**Schritt 2:** Gib folgenden Befehl ein (alles in einer Zeile):

```bash
mvn clean compile && java -cp target/classes ch.knapsack.redesign.strategy.AppRedesign2
```

**Das passiert:**

1.  `mvn clean compile`: Löscht alte Dateien und übersetzt deinen Java-Code neu.
2.  `java -cp ...`: Startet das Programm.

**Erwartete Ausgabe:**
Du siehst erst die Ausgabe für die **Greedy**-Strategie und direkt danach für die **Optimale (DP)**-Strategie.

---

## 2. Die Demo erklären

Öffne die Datei `src/main/java/ch/knapsack/redesign/strategy/AppRedesign2.java`.

Hier kannst du zeigen, wie das Strategy Pattern funktioniert:

1.  **Ein Rucksack, variable Strategie:**
    Zeige Zeile 20:

    ```java
    StrategyBackpack backpack = new StrategyBackpack(10, new GreedyPackingStrategy());
    ```
    
    _Erklärung:_ "Wir erstellen den Rucksack und geben ihm zum Start die 'Gierige' Strategie."

2.  **Der Wechsel (Der "Aha"-Moment):**
    Zeige Zeile 27:
    ```java
    backpack.setStrategy(new DpPackingStrategy());
    ```
    _Erklärung:_ "Hier tauschen wir das Gehirn des Rucksacks aus. Das Objekt `backpack` bleibt dasselbe, aber es verhält sich jetzt anders."

---

## 3. Demo live anpassen

Du kannst den Code ändern, um zu zeigen, dass es wirklich dynamisch ist.

### Szenario A: Items ändern

Ändere die Liste der Items in `AppRedesign2.java` (Zeilen 10-16).

**Beispiel:** Füge ein Item hinzu, das Greedy "verwirrt" (z.B. ein schweres Item, das den Rucksack fast voll macht, aber eine bessere Kombination verhindert).

```java
List<Item> items = Arrays.asList(
    new Item(9),  // Greedy nimmt sofort die 9
    new Item(5),  // Passt nicht mehr (9+5 > 10)
    new Item(5)   // Passt nicht mehr
    // Optimal wäre: 5 + 5 = 10. Greedy hat nur 9.
);
```

1.  Code speichern (`Cmd+S` oder `Strg+S`).
2.  Befehl im Terminal erneut ausführen (Pfeiltaste nach oben drücken).
3.  **Ergebnis:** Greedy hat 9g, Optimal hat 10g.

### Szenario B: Kapazität ändern

Ändere die Kapazität des Rucksacks in Zeile 20.

```java
// Ändere 10 zu 20
StrategyBackpack backpack = new StrategyBackpack(20, new GreedyPackingStrategy());
```

1.  Speichern.
2.  Ausführen.
3.  Beobachten, wie jetzt viel mehr Items reinpassen.

### Szenario C: Strategie-Reihenfolge tauschen

Du kannst zeigen, dass du jederzeit wechseln kannst.

```java
// Start mit DP
StrategyBackpack backpack = new StrategyBackpack(10, new DpPackingStrategy());
...
// Wechsel zu Greedy
backpack.setStrategy(new GreedyPackingStrategy());
```

## Zusammenfassung der Befehle

| Aktion                              | Befehl                                                                                    |
| :---------------------------------- | :---------------------------------------------------------------------------------------- |
| **Alles neu bauen & starten**       | `mvn clean compile && java -cp target/classes ch.knapsack.redesign.strategy.AppRedesign2` |
| **Nur starten (wenn schon gebaut)** | `java -cp target/classes ch.knapsack.redesign.strategy.AppRedesign2`                      |
