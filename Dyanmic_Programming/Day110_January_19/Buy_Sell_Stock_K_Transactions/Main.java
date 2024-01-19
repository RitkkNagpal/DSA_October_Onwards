import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int maxProfit = buySellStocksKTransactions(prices, k);
        System.out.println(maxProfit);
        scn.close();
    }

    private static int buySellStocksKTransactions(int[] prices, int k) {
        int n = prices.length;
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < dp[0].length; j++) {
                // int maxPriceKMinus1Trans = 0;
                // for (int idx = j-1; idx >= 0; idx--) {
                // maxPriceKMinus1Trans = Math.max(maxPriceKMinus1Trans, (prices[j] -
                // prices[idx]) + dp[i - 1][idx]);
                // }
                if (dp[i - 1][j - 1] - prices[j - 1] > max) {
                    max = dp[i - 1][j - 1] - prices[j - 1];
                }
                dp[i][j] = Math.max(max + prices[j], dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
}