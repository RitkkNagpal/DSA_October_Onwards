import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] costs = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = scn.nextInt();
            }
        }
        long minCostToPaintAllHouses = minCostPaintHouses(costs);
        System.out.println(minCostToPaintAllHouses);
        scn.close();
    }

    private static void display(long[][] twoDArr) {
        for (long[] oneDArr : twoDArr) {
            for (long ele : oneDArr) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static long minCostPaintHouses(int[][] costs) {
        int n = costs.length;
        long[][] dp = new long[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
