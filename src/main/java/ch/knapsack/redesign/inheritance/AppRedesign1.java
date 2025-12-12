package ch.knapsack.redesign.inheritance;

import ch.knapsack.model.Item;
import java.util.Arrays;
import java.util.List;

public class AppRedesign1 {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item(6), new Item(4), new Item(3), new Item(3), new Item(2), new Item(2), new Item(1)
        );
        int capacity = 10;

        System.out.println("--- Redesign 1: Inheritance ---");
        
        OptimalDpBackpack dpBackpack = new OptimalDpBackpack(capacity);
        dpBackpack.pack(items);
        printBackpack("Optimal DP", dpBackpack);

        GreedyBackpack greedyBackpack = new GreedyBackpack(capacity);
        greedyBackpack.pack(items);
        printBackpack("Greedy", greedyBackpack);
    }

    private static void printBackpack(String strategyName, AbstractBackpack backpack) {
        System.out.println("Strategie: " + strategyName);
        System.out.println("Max: " + backpack.getMaxWeightGrams() + "g, Aktuell: " + backpack.getCurrentWeightGrams() + "g");
        System.out.print("Items: ");
        for (Item item : backpack.getItems()) {
            System.out.print(item.getWeightGrams() + " ");
        }
        System.out.println("\n");
    }
}
