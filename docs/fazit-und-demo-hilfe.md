# Fazit und Demo-Hilfe

## Vergleich der Varianten

| Variante                   | Ansatz                  | Flexibilitaet                     | Komplexitaet |
| :------------------------- | :---------------------- | :-------------------------------- | :----------- |
| **Grundmodell**            | Manuelles `addItem`     | Gering (Nutzer muss denken)       | Niedrig      |
| **Smarter Rucksack**       | Logik fest im Rucksack  | Mittel (automatisch, aber fix)    | Mittel       |
| **Redesign 1 (Vererbung)** | Strategie per Subklasse | Mittel (Strategie fix pro Objekt) | Mittel-Hoch  |
| **Redesign 2 (Strategy)**  | Strategie austauschbar  | Hoch (Laufzeit-Wechsel)           | Hoch         |

## Wann welche Loesung?

- **Vererbung:** Wenn sich das Verhalten nie aendern muss (z.B. "Dieser Rucksack ist _immer_ ein Wanderrucksack").
- **Strategy Pattern:** Wenn man flexibel bleiben will (z.B. "Heute wandern, morgen Schule" -> Verhalten aendern).

## Demo-Spickzettel (Merkpunkte)

1.  **Problem:** Rucksack hat Limit, wir wollen optimal packen.
2.  **Lösung 1 (Vererbung):** Wir haben zwei _verschiedene_ Rucksack-Typen gebaut (`Optimal` und `Greedy`). Zeigt saubere Trennung, ist aber starr.
3.  **Lösung 2 (Strategy):** Wir haben _einen_ Rucksack, dem wir das "Gehirn" (Strategie) austauschen koennen. Das ist modernes, flexibles Software-Design.
4.  **Ergebnis:** Beide Designs liefern das gleiche Ergebnis (siehe Konsolen-Output), aber der Weg dahin (Architektur) ist anders.
5.  **Takeaway:** Design Patterns wie Strategy machen Code wartbarer und flexibler.
