import java.util.Scanner;

public class L2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Input");
            return;
        }
        
        int availableHours = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Input");
            return;
        }

        int devicesToTest = scanner.nextInt();
        
        if (availableHours < 4) {
            System.out.println("Invalid Input");
        } else {
            int devicesTested = availableHours / 4;
            devicesTested = Math.min(devicesTested, devicesToTest);
            int remainingDevices = devicesToTest - devicesTested;

            System.out.println(devicesTested);
            System.out.println(remainingDevices);
        }
    }
}
