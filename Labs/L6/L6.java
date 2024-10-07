import java.util.*;

public class L6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(); 
        
        int ret = doSomething(a);        
        System.out.println(ret);
    }
    
    public static int doSomething(int x) {
        for (int num = x - 1; num >= 2; num--) {
            if (isPrime(num) && isSpecialPrime(num)) {
                return num;
            }
        }
        return -1; // Return -1 if no special prime is found
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isSpecialPrime(int num) {
        String strNum = Integer.toString(num);
        // Check if all permutations are prime
        return checkAllPermutations(strNum);
    }

    public static boolean checkAllPermutations(String digits) {
        Set<String> permutations = new HashSet<>();
        permute(digits, "", permutations);
        // Check each permutation
        for (String perm : permutations) {
            if (!perm.isEmpty() && !isPrime(Integer.parseInt(perm))) {
                return false; // If any permutation is not prime
            }
        }
        return true; // All permutations are prime
    }

    public static void permute(String str, String current, Set<String> permutations) {
        if (current.length() == str.length()) {
            permutations.add(current); // Add the current permutation to the set
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (current.indexOf(str.charAt(i)) == -1) { // Check if character is already used
                permute(str, current + str.charAt(i), permutations);
            }
        }
    }
}
