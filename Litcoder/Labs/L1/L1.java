import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLine()) {
            System.out.println("No input provided");
            return;
        }

        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        int n = inputArray.length;

        if (n < 1 || n > 10) {
            System.out.println("Array size must be between 1 and 10");
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            try {
                arr[i] = Integer.parseInt(inputArray[i]);
                if (arr[i] < -10 || arr[i] > 10) {
                    System.out.println("Array elements must be from -10 to 10");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Array elements must be integers");
                return;
            }
        }
        boolean found = hasZeroSumSubarray(arr);
        System.out.println(found ? "True" : "False");
        System.out.println(n);
    }

    public static boolean hasZeroSumSubarray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;
            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }
}
                                                                                                                            