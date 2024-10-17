import java.util.*;

public class L11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n1 = input.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = input.nextInt();
        }

        int n2 = input.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = input.nextInt();
        }

        int n3 = input.nextInt();
        int[] arr3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            arr3[i] = input.nextInt();
        }

        List<Integer> commonElements = findCommonElements(arr1, arr2, arr3);

        if (commonElements.isEmpty()) {
            System.out.println("NO Elements");
        } else {
            for (int element : commonElements) {
                System.out.print(element + " ");
            }
        }
    }

    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }
}
