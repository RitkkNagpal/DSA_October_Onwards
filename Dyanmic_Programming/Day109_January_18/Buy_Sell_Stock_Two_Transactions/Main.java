import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        int ways = buySellStockTwoTransaction(prices);
        System.out.println(ways);
        scn.close();
    }

    private static int buySellStockTwoTransaction(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int[][] dp = new int[2][n];
        int minBuyDayPrice = prices[0]; // min price so far
        int maxSellingdayProfit = 0; // max Profit So Far

        // dp[0][i] -> max profit uptil now or before if sold today
        for (int i = 1; i < n; i++) {
            if (prices[i] < minBuyDayPrice) {
                minBuyDayPrice = prices[i];
            }
            int currProfit = prices[i] - minBuyDayPrice;
            dp[0][i] = Math.max(currProfit, maxSellingdayProfit);
            maxSellingdayProfit = Math.max(maxSellingdayProfit, dp[0][i]);
        }

        int maxSellingDayPrice = prices[n - 1];
        int maxBuyingDayProfit = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > maxSellingDayPrice) {
                maxSellingDayPrice = prices[i];
            }
            int currProfit = maxSellingDayPrice - prices[i];
            dp[1][i] = Math.max(currProfit, maxBuyingDayProfit);
            maxBuyingDayProfit = Math.max(maxBuyingDayProfit, dp[1][i]);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(dp[0][i] + dp[1][i], ans);
        }
        return ans;
    }
}