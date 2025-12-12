package ch.knapsack.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Ein smarter Rucksack, der automatisch die optimale Teilmenge von Items
 * mittels dynamischer Programmierung (0-1 Knapsack) auswählt.
 */
public class SmartBackpack extends Backpack {

    /**
     * Erstellt einen neuen SmartBackpack mit dem angegebenen Maximalgewicht.
     *
     * @param maxWeightGrams das maximale Gewicht in Gramm (muss > 0 sein)
     * @throws IllegalArgumentException wenn maxWeightGrams <= 0
     */
    public SmartBackpack(int maxWeightGrams) {
        super(maxWeightGrams);
    }

    /**
     * Packt die optimale Teilmenge der gegebenen Items in den Rucksack.
     * Der Rucksack wird zuerst geleert, dann werden Items so ausgewählt,
     * dass das Gesamtgewicht maximal ist, ohne das Maximalgewicht zu überschreiten.
     *
     * @param itemsToPack die zu packenden Items
     * @throws NullPointerException wenn itemsToPack null ist oder ein Element null
     *                              ist
     */
    public void pack(Collection<Item> itemsToPack) {
        if (itemsToPack == null) {
            throw new NullPointerException("itemsToPack darf nicht null sein");
        }
        for (Item item : itemsToPack) {
            if (item == null) {
                throw new NullPointerException("Kein Item in der Collection darf null sein");
            }
        }

        // Zuerst leeren - SmartBackpack packt immer "neu"
        clear();

        List<Item> list = new ArrayList<>(itemsToPack);
        int n = list.size();
        int capacity = getMaxWeightGrams();

        // Berechne Summe aller Gewichte
        int totalWeight = 0;
        for (Item item : list) {
            totalWeight += item.getWeightGrams();
        }

        // Wenn alle Items passen, füge alle hinzu
        if (totalWeight <= capacity) {
            for (Item item : list) {
                addItem(item);
            }
            return;
        }

        // Dynamische Programmierung (Subset Sum / 0-1 Knapsack ohne Werte)
        boolean[] dp = new boolean[capacity + 1];
        int[] prev = new int[capacity + 1];
        int[] chosenIndex = new int[capacity + 1];

        // Initialisierung
        dp[0] = true;
        for (int i = 0; i <= capacity; i++) {
            prev[i] = -1;
            chosenIndex[i] = -1;
        }

        // DP-Iteration: für jedes Item
        for (int i = 0; i < n; i++) {
            int wi = list.get(i).getWeightGrams();
            // Von capacity runter bis wi iterieren (um jedes Item nur einmal zu nutzen)
            for (int w = capacity; w >= wi; w--) {
                if (dp[w - wi] && !dp[w]) {
                    dp[w] = true;
                    prev[w] = w - wi;
                    chosenIndex[w] = i;
                }
            }
        }

        // Bestimme bestes Gewicht (größtes w mit dp[w] == true)
        int best = 0;
        for (int w = capacity; w >= 0; w--) {
            if (dp[w]) {
                best = w;
                break;
            }
        }

        // Rekonstruiere Teilmenge rückwärts
        List<Item> selectedItems = new ArrayList<>();
        int w = best;
        while (w > 0 && chosenIndex[w] != -1) {
            int idx = chosenIndex[w];
            selectedItems.add(list.get(idx));
            w = prev[w];
        }

        // Füge alle rekonstruierten Items hinzu
        for (Item item : selectedItems) {
            addItem(item);
        }
    }
}
