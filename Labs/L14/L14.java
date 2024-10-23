import java.util.*;

public class L14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String start = input.next();
        String end = input.next();
        boolean result = doSomething(start, end);
        System.out.println(result);
        input.close();
    }

    public static boolean doSomething(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }

        int countL1 = 0, countR1 = 0, countX1 = 0;
        int countL2 = 0, countR2 = 0, countX2 = 0;

        for (char ch : start.toCharArray()) {
            if (ch == 'L') countL1++;
            else if (ch == 'R') countR1++;
            else if (ch == 'X') countX1++;
        }

        for (char ch : end.toCharArray()) {
            if (ch == 'L') countL2++;
            else if (ch == 'R') countR2++;
            else if (ch == 'X') countX2++;
        }

        if (countL1 != countL2 || countR1 != countR2 || countX1 != countX2) {
            return false;
        }

        int balance = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                balance++;
            } else if (start.charAt(i) == 'L') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }

        balance = 0;
        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == 'R') {
                balance++;
            } else if (end.charAt(i) == 'L') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }

        return true;
    }
}
