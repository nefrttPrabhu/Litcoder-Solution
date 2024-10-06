import java.util.*;

public class PrePC2 {
    static List<List<Integer>> combinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int targetBudget = scanner.nextInt();
            if (targetBudget <= 0) {
                System.out.println("Invalid input");
                return;
            }

            int stockCount = scanner.nextInt();
            String[] stockNames = new String[stockCount];
            int[] stockPrices = new int[stockCount];

            for (int i = 0; i < stockCount; i++) {
                stockNames[i] = scanner.next();
                stockPrices[i] = scanner.nextInt();

                if (stockPrices[i] <= 0) {
                    System.out.println("The stock prices should be at least greater than 0");
                    return;
                }

                if (stockPrices[i] > targetBudget) {
                    System.out.println("One of the stock prices is higher than the target price");
                    return;
                }
            }

            findCombinations(stockPrices, new int[stockCount], 0, targetBudget);
            Collections.sort(combinations, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });

            for (List<Integer> combination : combinations) {
                for (int qty : combination) {
                    System.out.print(qty + " ");
                }
                System.out.println();
            }
            System.out.println(combinations.size());

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void findCombinations(int[] prices, int[] quantities, int idx, int budget) {
        if (budget == 0) {
            List<Integer> combination = new ArrayList<>();
            for (int qty : quantities) {
                combination.add(qty);
            }
            combinations.add(combination);
            return;
        }
        if (budget < 0 || idx == prices.length) {
            return;
        }

        for (int i = 0; i <= 5; i++) {
            quantities[idx] = i;
            findCombinations(prices, quantities, idx + 1, budget - i * prices[idx]);
        }
    }
}