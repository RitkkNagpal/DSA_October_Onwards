import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = scn.nextInt();
            }
        }
        long ans = minCostPaintHousesKColors(costs);
        long ansOptimized = minCostPaintHousesKColorsOptimized(costs);
        System.out.println(ans);
        System.out.println(ansOptimized);
        scn.close();
    }

    private static long minCostPaintHousesKColors(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        long[][] dp = new long[n][k];
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                long min = Integer.MAX_VALUE;
                for (int item = 0; item < k; item++) {
                    if (item == j) {
                        continue;
                    } else {
                        min = Math.min(min, dp[i - 1][item]);
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        long min = dp[n - 1][0];
        for (int j = 1; j < k; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }

    private static long minCostPaintHousesKColorsOptimized(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        long[][] dp = new long[n][k];
        long least = Long.MAX_VALUE;
        long sLeast = Long.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            if (least >= dp[0][j]) {
                least = dp[0][j];
                sLeast = least;
            } else if (sLeast >= dp[0][j]) {
                sLeast = dp[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            long nLeast = Long.MAX_VALUE; // least
            long nSLeast = Long.MAX_VALUE; // second least
            for (int j = 0; j < k; j++) {
                if (least != dp[i - 1][j]) {
                    dp[i][j] = least + costs[i][j];
                } else {
                    dp[i][j] = sLeast + costs[i][j];
                }
                if (nLeast >= dp[i][j]) {
                    nLeast = dp[i][j];
                    nSLeast = nLeast;
                } else if (nSLeast >= dp[i][j]) {
                    nSLeast = dp[i][j];
                }
            }
            least = nLeast;
            sLeast = nSLeast;
        }
        long min = dp[n - 1][0];
        for (int j = 1; j < k; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
