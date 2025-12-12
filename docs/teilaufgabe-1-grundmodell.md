# Teilaufgabe 1: Grundmodell

**Bezug auf Diagramm:** `docs/knapsack-1.png`

## Das Grundproblem

Wir modellieren eine klassische Situation: Ein Rucksack mit begrenzter Tragkraft soll mit verschiedenen Gegenstaenden befüllt werden.

## Klasse Item

- **Aufgabe:** Repraesentiert einen einzelnen Gegenstand.
- **Unveraenderliches Gewicht:** Das Gewicht (`weightGrams`) ist `protected` und hat keinen Setter. Einmal erstellt, wiegt der Gegenstand immer gleich viel. Das verhindert Inkonsistenzen.
- **Gleichheit:** Zwei Items gelten als "gleich", wenn sie dasselbe Gewicht haben. Der Name ist rein informativ und optional.

## Klasse Backpack

- **Maximalgewicht:** Wird im Konstruktor gesetzt und kann nicht mehr geaendert werden (Rucksack wird nicht grösser).
- **addItem Methode:**
  - Gibt `boolean` zurück: `trü` = erfolgreich gepackt, `false` = zu schwer.
  - Verhindert aktiv, dass der Rucksack überladen wird.
- **Ziel:** Eine stabile, einfache Basis schaffen, die fehlerhafte Zustaende (z.B. negatives Gewicht, überladung) technisch unmöglich macht.
