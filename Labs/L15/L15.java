import java.util.Scanner;

public class L15 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        long ret = legoWall(n, m);
        System.out.println(ret);
    }

    public static long legoWall(int n, int m) {
        long[] widthWays = new long[m + 1];
        widthWays[0] = 1;

        for (int i = 1; i <= m; i++) {
            widthWays[i] = widthWays[i - 1];
            if (i - 2 >= 0) widthWays[i] = (widthWays[i] + widthWays[i - 2]) % MOD;
            if (i - 3 >= 0) widthWays[i] = (widthWays[i] + widthWays[i - 3]) % MOD;
            if (i - 4 >= 0) widthWays[i] = (widthWays[i] + widthWays[i - 4]) % MOD;
        }

        long[] totalWays = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            totalWays[i] = 1;
            for (int j = 0; j < n; j++) {
                totalWays[i] = (totalWays[i] * widthWays[i]) % MOD;
            }
        }

        long[] solidWallWays = new long[m + 1];
        solidWallWays[0] = 1;

        for (int i = 1; i <= m; i++) {
            long invalidWays = 0;
            for (int j = 1; j < i; j++) {
                invalidWays = (invalidWays + solidWallWays[j] * totalWays[i - j]) % MOD;
            }
            solidWallWays[i] = (totalWays[i] - invalidWays + MOD) % MOD;
        }

        return solidWallWays[m];
    }
}