import java.util.*;

public class L10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int arraySize = input.nextInt();
        int[] array = new int[arraySize + 1];

        int queryCount = input.nextInt();

        for (int i = 0; i < queryCount; i++) {
            int start = input.nextInt() - 1;
            int end = input.nextInt();
            int value = input.nextInt();

            array[start] += value;
            if (end < arraySize) {
                array[end] -= value;
            }
        }

        int maxVal = 0;
        int currentSum = 0;
        for (int i = 0; i < arraySize; i++) {
            currentSum += array[i];
            maxVal = Math.max(maxVal, currentSum);
        }

        System.out.println(maxVal);
    }
}
