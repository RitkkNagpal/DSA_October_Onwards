import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long ways = friendsPairing(n);
        System.out.println(ways);
        scn.close();
    }

    private static long friendsPairing(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + ((i - 1) * dp[i - 2]);
        }
        return dp[n];
    }
}
