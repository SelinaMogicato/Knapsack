# Teilaufgabe 4: Redesign 1 (Vererbung)

**Bezug auf Diagramm:** `docs/redesign1.png`

## Warum ein Redesign?

Wir wollten verschiedene Strategien (Optimal vs. Schnell) sauber trennen, anstatt alles in eine Klasse zu stopfen oder Code zu kopieren.

## Grundidee: Vererbung

Wir nutzen die Hierarchie, um gemeinsames Verhalten zu teilen und spezielles Verhalten auszulagern.

- **Interface `Packable`:** Definiert den Vertrag "Ich kann Dinge packen".
- **Abstrakte Klasse `AbstractBackpack`:**
  - Verwaltet die Basis-Daten (Gewicht, Liste der Items).
  - Implementiert Standard-Methoden (`addItem`, `clear`).
  - Laesst die `pack`-Methode offen für die Kinder.

## Die Subklassen

1.  **`OptimalDpBackpack`:** Implementiert `pack` mit der perfekten, aber langsamen Strategie (Dynamische Programmierung).
2.  **`GreedyBackpack`:** Implementiert `pack` mit der gierigen Strategie (Sortieren nach Gewicht, rein was passt). Schnell, aber nicht immer perfekt.

## Vor- und Nachteile

- **Vorteil:** Sauberer Code, keine Duplizierung der Basis-Logik. Klar definierte Klassen für jeden Zweck.
- **Nachteil:** Die Strategie ist fest in die Klasse eingebrannt. Ein `GreedyBackpack` kann niemals seine Strategie zu `Optimal` aendern. Man müsste einen neuen Rucksack kaufen (instanziieren).
