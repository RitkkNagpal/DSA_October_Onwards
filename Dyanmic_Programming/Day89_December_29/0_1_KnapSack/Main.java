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
        int ans = zero_oneKnapSack(values, weights, cap);
        System.out.println(ans);
        scn.close();
    }

    private static int zero_oneKnapSack(int[] values, int[] weights, int cap) {
        int[][] dp = new int[weights.length + 1][cap + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= weights[i - 1]) {
                        int inc = dp[i - 1][j - weights[i - 1]] + values[i - 1]; // inclusive
                        dp[i][j] = Math.max(dp[i - 1][j], inc);
                    }
                }
            }
        }
        int max = dp[0][cap];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i][cap]);
        }
        display(dp);
        return max;
    }

    private static void display(int[][] dp) {
        for (int values[] : dp) {
            for (int value : values) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
