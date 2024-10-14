import java.util.*;

public class C2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        if (input.hasNextLine()) {
            String[] arrStr = input.nextLine().split(" ");
            int[] arr = Arrays.stream(arrStr).mapToInt(Integer::parseInt).toArray();
            
            if (input.hasNextInt()) {
                int k = input.nextInt();
                String result = checkDuplicatesWithinDistance(arr, k);
                System.out.println(result);
            }
        }
    }

    public static String checkDuplicatesWithinDistance(int[] arr, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            
            if (lastSeen.containsKey(currentElement)) {
                int previousIndex = lastSeen.get(currentElement);
                if (i - previousIndex <= k) {
                    return "Yes";
                }
            }
            
            lastSeen.put(currentElement, i);
        }
        
        return "No";
    }
}
