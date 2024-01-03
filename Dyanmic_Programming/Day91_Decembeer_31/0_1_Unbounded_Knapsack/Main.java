import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        int ans = unbounded_knapsack(values, weights, cap);
        System.out.println(ans);
        scn.close();
    }

    private static int unbounded_knapsack(int[] values, int[] weights, int cap) {
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }
        return dp[cap];
    }
}
