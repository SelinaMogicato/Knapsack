# Teilaufgabe 5: Redesign 2 (Strategy Pattern)

**Bezug auf Diagramm:** `docs/redesign2.png`

## Motivation

Das Problem bei Redesign 1 war die Starrheit. Wir wollen einen Rucksack, der seine Pack-Strategie je nach Situation aendern kann (z.B. "jetzt schnell", "jetzt genau").

## Das Strategy Pattern

Wir lagern das "Wie gepackt wird" in eigene kleine Klassen aus.

- **Interface `PackingStrategy`:** Definiert nur die Methode `selectItems`. Der Rucksack fragt die Strategie: "Was soll ich nehmen?"
- **Strategien:**
  - `DpPackingStrategy`: Die schlaue Strategie.
  - `GreedyPackingStrategy`: Die schnelle Strategie.

## Rolle von StrategyBackpack

- Der Rucksack ist nur noch der "Container".
- Er besitzt eine Strategie (`Has-A` Beziehung statt `Is-A`).
- Er delegiert die Entscheidung an die Strategie.

## Flexibilitaet

- Durch `setStrategy(...)` künnen wir zur Laufzeit das Verhalten aendern.
- **Beispiel:** Erst schnell vorsortieren (Greedy), dann merken wir, es ist noch Zeit, und wechseln auf genau (DP).

## Vergleich zu Vererbung

- **Vorteil:** Maximale Flexibilitaet. Trennung von Daten (Rucksack) und Algorithmus (Strategie).
- **Nachteil:** Etwas mehr Klassen und Schnittstellen (Overhead), für sehr simple Probleme vielleicht Overkill.
