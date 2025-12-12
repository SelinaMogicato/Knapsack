# Sitzungsprotokoll Code Review – Knapsack (Teilaufgabe 7)

**Datum:** [TT.MM.JJJJ]  
**Zeit:** [hh:mm] – [hh:mm]  
**Ort:** Schule

**Teilnehmende:**

- Selina
- Lysandro

**Ziel des Meetings:**  
Vergleich der beiden Lösungen (Design und Implementierung) zum Knapsack/Rucksack. Diskussion von Alternativen sowie Bewertung von Laufzeit und Approximationsgüte.

---

## 1) Kurzübersicht der eigenen Lösung (mein Stand)

### Klassen und Design

- **Item**
  - Attribute (protected): `weightGrams:int`, `name:String` (optional)
  - Unveraenderlich (keine Setter)
  - Gleichheit: Zwei Items gelten als gleich, wenn `weightGrams` gleich ist (Name wird ignoriert)
- **Backpack**
  - Attribute (protected): `maxWeightGrams:int`, `items:List<Item>`
  - `addItem(Item):boolean` fügt ein Item nur hinzu, wenn das Maximalgewicht nicht überschritten wird
  - Weitere Methoden: `getCurrentWeightGrams()`, `clear()`, `getItems()` (unveraenderliche Sicht)
- **SmartBackpack extends Backpack**
  - Methode `pack(Collection<Item>)` zum Packen mehrerer Gegenstaende
  - Wenn die Summe aller Gewichte <= Maximalgewicht ist, werden alle Items gepackt
  - Wenn die Summe > Maximalgewicht ist, wird eine optimale Teilmenge bestimmt

### Algorithmus

- Verwendeter Ansatz: **dynamische Programmierung (Subset Sum / 0-1 Knapsack ohne Werte)**
- Ziel: maximales Gesamtgewicht <= Maximalgewicht
- Rekonstruktion der gewaehlten Items über Hilfsarrays

### Unit-Tests (eigene Seite)

- **BackpackTest:** prüft, dass das Maximalgewicht nicht überschritten werden kann
- **SmartBackpackTest:** prüft mit einem konkreten Fallbeispiel, dass das optimale Gewicht erreicht wird  
  (z.B. Gewichte 6, 4, 3, 3 bei Maximalgewicht 10 → optimales Gewicht 10)

---

## 2) Kurzübersicht der Partner-Lösung

### Klassen und Design (Partner)

- [Partner: Welche Klassen gibt es?]
- [Partner: Wie ist das Design aufgebaut?]
- [Partner: Wie wird Gleichheit von Items definiert?]
- [Partner: Wie wird das Packen mehrerer Gegenstaende gelöst?]

### Unit-Tests (Partner)

- [Partner: Welche Tests existieren?]
- [Partner: Gibt es Tests zur Optimalitaet? Falls ja, welches Fallbeispiel?]

---

## 3) Unterschiede im Design (Klassendiagramme)

### Gemeinsamkeiten

- Gegenstaende besitzen ein Gewicht
- Ein Rucksack hat ein Maximalgewicht und enthaelt mehrere Items
- Es existiert eine Logik zum Hinzufügen bzw. Packen von Items

### Unterschiede

- **Meine Lösung**
  - `SmartBackpack` ist eine Subklasse von `Backpack`
  - Batch-Packen über `pack(...)`
  - Optimale Auswahl per dynamischer Programmierung
- **Partner-Lösung**
  - [Partner: z.B. keine Vererbung / andere Struktur]
  - [Partner: anderer Algorithmus (greedy, brute force, etc.)]

---

## 4) Code-Durchgang und alternative Implementierungen

### Eigene Implementierung

- Saubere Validierung (Null-Checks, positive Gewichte)
- Keine Veraenderung interner Daten von aussen (`unmodifiableList`)
- Klare Trennung zwischen einfachem Rucksack und smartem Rucksack

### Diskutierte Alternativen

- **Greedy-Algorithmen**
  - Vorteil: sehr schnell und einfach
  - Nachteil: oft nicht optimal
- **Brute Force**
  - Vorteil: garantiert optimal
  - Nachteil: exponentielle Laufzeit
- **Dynamische Programmierung (verwendet)**
  - Vorteil: optimale Lösung
  - Nachteil: Laufzeit und Speicherverbrauch haengen vom Maximalgewicht ab

### Partner-Anmerkungen

- [Partner: alternative Vorschlaege oder Verbesserungen]

---

## 5) Vergleich: Laufzeit und Approximationsgüte

### Meine Lösung

- **Genauigkeit:** optimal
- **Laufzeit:** O(n \* Maximalgewicht)
- **Speicher:** O(Maximalgewicht)
- **Geeignet für:** kleine bis mittlere Maximalgewichte (z.B. Schulbeispiele)

### Partner-Lösung

- **Genauigkeit:** [Partner]
- **Laufzeit:** [Partner]
- **Speicher:** [Partner]
- **Geeignet für:** [Partner]

### Vor- und Nachteile

- **Meine Vorteile:** optimale Ergebnisse, gut testbar
- **Meine Nachteile:** bei sehr grossem Maximalgewicht langsamer
- **Partner Vorteile:** [Partner]
- **Partner Nachteile:** [Partner]

---

## 6) Beschlüsse und ToDos

### Beschlüsse

- [ ] [z.B. Beide Lösungen werden dokumentiert und verglichen]
- [ ] [z.B. Fokus auf Erklaerung der Trade-offs]

### ToDos

- [ ] Partner-Teil ergaenzen
- [ ] Protokoll auf maximal eine A4-Seite kürzen
- [ ] Finale Version ins Projekt ablegen
