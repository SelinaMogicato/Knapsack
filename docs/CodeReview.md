# Sitzungsprotokoll Code Review – Knapsack (Teilaufgabe 7)

**Datum:** 18.12.2025  
**Zeit:** 10:15 – 10:45  
**Ort:** Schule

**Teilnehmende:**
- Selina
- Lysandro

**Ziel des Meetings:**  
Vergleich der beiden Lösungen (Design und Implementierung) zum Knapsack/Rucksack, inklusive Diskussion von Alternativen sowie Bewertung von Laufzeit und Approximationsgüte.
---
## 1) Eigene Lösung – Kurzübersicht
### Klassen und Design
- **Item**
  - Attribute (protected): `weightGrams`, `name` (optional)
  - Unveränderlich, keine Setter
  - Gleichheit nur über das Gewicht
- **Backpack**
  - Attribute (protected): `maxWeightGrams`, `items`
  - `addItem` gibt boolean zurück, falls Maximalgewicht überschritten würde
- **SmartBackpack**
  - Packt mehrere Items auf einmal
  - Bei Überschreitung wird eine optimale Teilmenge berechnet
### Algorithmus
- Dynamische Programmierung (Subset Sum / 0-1 Knapsack ohne Werte)
- Ziel: maximales Gewicht <= Maximalgewich
- Rekonstruktion der gewählten Items über Hilfsarrays
### Tests
- Test für Einhaltung des Maximalgewichts
- Test, der ein bekannt optimales Ergebnis prüft (z.B. 6+4=10)
---
## 2) Partner-Lösung – Kurzübersicht
### Klassen und Design
- Klassen: `Item`, `Backpack`, `SmartBackpack`
- Einfacheres Design ohne komplexe Vererbung
- Gleichheit von Items über Gewicht **und** Name
- Packen mehrerer Items mit Greedy-Ansatz (schwerste zuerst)
### Tests
- Tests für korrektes Hinzufügen von Items
- Kein Test, der garantiert ein optimales Ergebnis prüft
---
## 3) Unterschiede im Design
### Gemeinsamkeiten
- Items mit Gewicht
- Rucksack mit Maximalgewicht
- Logik zum Packen von Gegenständen
### Unterschiede
- **Meine Lösung:** optimale Packung mit dynamischer Programmierung
- **Partner-Lösung:** Greedy-Algorithmus, schneller aber nicht immer optimal
---
## 4) Diskussion und Alternativen
- **Greedy**
  - + Sehr schnell, einfach
  - – Kann falsche (suboptimale) Ergebnisse liefern
- **Brute Force**
  - + Immer optimal
  - – Sehr schlechte Laufzeit
- **Dynamische Programmierung (verwendet)**
  - + Optimal
  - – Abhängig vom Maximalgewicht
Partner plant, Teile der optimalen Strategie später zu übernehmen.
---
## 5) Laufzeit
- **Meine Lösung**
  - Genauigkeit: optimal
  - Laufzeit: O(n * Maximalgewicht)
  - Speicher: O(Maximalgewicht)
- **Partner-Lösung**
  - Genauigkeit: nicht immer optimal
  - Laufzeit: O(n log n)
  - Speicher: O(n)
---
## 6) Beschlüsse
- [x] Beide Lösungen werden dokumentiert und verglichen
- [x] Code Review wird im Projekt abgelegt
