import java.util.Scanner;

public class L4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("4dig int");
        String input = scanner.next();
        
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("enter");
                return;
            }
        }
        
        int num = Integer.parseInt(input);
        
        if (input.length() < 4) {
            System.out.println("less than 4");
            return;
        } else if (input.length() > 4) {
            System.out.println("more than 4");
            return;
        }
        
        if (num <= 0) {
            System.out.println("+ve int");
            return;
        }

        int[] digits = new int[4];
        for (int i = 3; i >= 0; --i) {
            digits[i] = num % 10;
            num /= 10;
        }
        
        for (int i = 0; i < 4; ++i) {
            digits[i] = (digits[i] + 5) % 10;
        }
        
        int temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;
        
        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;
        
        for (int digit : digits) {
            System.out.print(digit);
        }
    }
}
