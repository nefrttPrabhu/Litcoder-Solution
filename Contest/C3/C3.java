import java.util.*;

public class C3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] arrStr = input.nextLine().split(" ");
        int[] arr = Arrays.stream(arrStr).mapToInt(Integer::parseInt).toArray();
        printChunks(arr);
    }
    
    public static void printChunks(int[] arr) {
        List<List<Integer>> chunks = new ArrayList<>();
        List<Integer> currentChunk = new ArrayList<>();
        
        int maxSoFar = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentChunk.add(arr[i]);
            maxSoFar = Math.max(maxSoFar, arr[i]);
            
            if (maxSoFar == i) {
                chunks.add(new ArrayList<>(currentChunk));
                currentChunk.clear();
            }
        }
        
        for (List<Integer> chunk : chunks) {
            for (int num : chunk) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
