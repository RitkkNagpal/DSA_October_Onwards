import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] steps = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                steps[i][j] = scn.nextInt();
            }
        }
        int minCost = minCostMazeTraversal(steps);
        System.out.println(minCost);
        scn.close();
    }

    private static int minCostMazeTraversal(int[][] steps) {
        int n = steps.length;
        int m = steps[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = steps[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = steps[i][j] + dp[i][j + 1];
                } else if (j == m - 1) {
                    dp[i][j] = steps[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = steps[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}