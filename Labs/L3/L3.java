import java.util.Scanner;

public class L3 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("No input provided");
            return;
        }

        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Array size must be at least 1");
            return;
        }

        int[] arr = new int[n];
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input detected. Please enter integers only.");
                return;
            }
            arr[i] = scanner.nextInt();
            if (arr[i] > 0) {
                positiveCount++;
            } else if (arr[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        double positiveRatio = (double) positiveCount / n;
        double negativeRatio = (double) negativeCount / n;
        double zeroRatio = (double) zeroCount / n;

        System.out.printf("%.3f\n", positiveRatio);
        System.out.printf("%.3f\n", negativeRatio);
        System.out.printf("%.3f\n", zeroRatio);
    }
}
