import java.util.*;

public class L8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        List<Integer> sightings = new ArrayList<>();
        while (input.hasNextInt()) {
            sightings.add(input.nextInt());
        }
        
        int result = findMostCommonPlant(sightings);
        System.out.println(result);
    }

    public static int findMostCommonPlant(List<Integer> sightings) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int id : sightings) {
            frequencyMap.put(id, frequencyMap.getOrDefault(id, 0) + 1);
        }
        
        int mostCommonId = -1;
        int maxCount = 0;
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int plantId = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount || (count == maxCount && plantId < mostCommonId)) {
                mostCommonId = plantId;
                maxCount = count;
            }
        }
        
        return mostCommonId;
    }
}
