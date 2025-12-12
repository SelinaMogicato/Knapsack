package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import java.util.Arrays;
import java.util.List;

public class AppRedesign2 {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(6), new Item(4), new Item(3), new Item(3), new Item(2), new Item(2), new Item(1));
        int capacity = 10;

        System.out.println("--- Redesign 2: Strategy Pattern ---");

        StrategyBackpack backpack = new StrategyBackpack(capacity, new GreedyPackingStrategy());
        backpack.pack(items);
        printBackpack("Greedy Strategy", backpack);

        backpack.setStrategy(new DpPackingStrategy());
        backpack.pack(items);
        printBackpack("DP Strategy", backpack);
    }

    private static void printBackpack(String strategyName, StrategyBackpack backpack) {
        System.out.println("Strategie: " + strategyName);
        System.out.println(
                "Max: " + backpack.getMaxWeightGrams() + "g, Aktuell: " + backpack.getCurrentWeightGrams() + "g");
        System.out.print("Items: ");
        for (Item item : backpack.getItems()) {
            System.out.print(item.getWeightGrams() + " ");
        }
        System.out.println("\n");
    }
}
