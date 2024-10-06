import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int ltrSum = 0, rtlSum = 0;

        for (int i = 0; i < n; i++) {
            ltrSum += matrix[i][i];
            rtlSum += matrix[i][n - i - 1];
        }

        int absoluteDifference = Math.abs(ltrSum - rtlSum);
        System.out.println(absoluteDifference);
    }
}
