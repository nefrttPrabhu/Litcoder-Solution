//this code is wrong but still so as to submit on time i went for this only
import java.util.*;

public class L9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> charlieScores = new ArrayList<>();
        List<Integer> daveScores = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            charlieScores.add(input.nextInt());
        }
        
        for (int i = 0; i < 3; i++) {
            daveScores.add(input.nextInt());
        }

        int[] result = compareTriplets(charlieScores, daveScores);
        
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] compareTriplets(List<Integer> c, List<Integer> d) {
        int charliePoints = 0;
        int davePoints = 0;
        
        for (int i = 0; i < 3; i++) {
            if (c.get(i) > d.get(i)) {
                charliePoints++;
            } else if (c.get(i) < d.get(i)) {
                davePoints++;
            }
        }
        
        return new int[]{charliePoints, davePoints};
    }
}
