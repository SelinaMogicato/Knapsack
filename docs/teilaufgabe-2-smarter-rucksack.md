# Teilaufgabe 2: Smarter Rucksack

**Bezug auf Diagramm:** `docs/knapsack-2.png`

## Warum reicht der normale Rucksack nicht?

Der normale `Backpack` nimmt Items einfach der Reihe nach an (`addItem`). Wenn man ungeschickt packt (z.B. erst viele kleine, unwichtige Dinge), passt das grosse, wichtige Teil am Ende nicht mehr rein, obwohl es theoretisch eine bessere Kombination gaebe.

## Die Klasse SmartBackpack

- **Erweiterung:** Erbt von `Backpack`.
- **"Smart" bedeutet:** Der Rucksack denkt mit. Er nimmt nicht einfach Items an, sondern bekommt eine ganze Sammlung (`pack(items)`) und entscheidet selbst, welche Kombination am besten ist.

## Optimale Packung & Dynamische Programmierung

- **Ziel:** Den Rucksack so voll wie möglich machen (Gewichtssumme maximal nahe am Limit), ohne das Limit zu überschreiten.
- **Methode:** Wir nutzen "Dynamische Programmierung" (Subset Sum Problem).
  - _Konzept:_ Wir testen systematisch Kombinationen und merken uns Zwischenergebnisse, um nicht alles doppelt zu berechnen.
- **Vorteile:** Garantiert immer das mathematisch bestmögliche Ergebnis.
- **Nachteile:** Rechenaufwendiger als einfaches "Reinwerfen".
