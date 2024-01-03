import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nthFib = getNthFibDP(n);
        System.out.println(nthFib);
        scn.close();
    }

    private static int getNthFibDP(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1]
                    + dp[i - 2];
        }
        return dp[n];
    }
}