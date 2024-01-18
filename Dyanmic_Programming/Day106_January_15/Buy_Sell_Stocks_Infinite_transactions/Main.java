import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        long maxProfitInfiniteTrans = buySellStocksInfiniteTransactions(prices);
        System.out.println(maxProfitInfiniteTrans);
        scn.close();
    }

    private static long buySellStocksInfiniteTransactions(int[] prices) {
        long totalProfit = 0;
        int currBuyIdx = 0;
        int currSellIdx = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                totalProfit += (prices[currSellIdx] - prices[currBuyIdx]);
                currBuyIdx = i;
            }
            currSellIdx = i;
        }

        if (currSellIdx == prices.length - 1 && prices[currSellIdx] > prices[currBuyIdx]) {
            totalProfit = prices[currSellIdx] - prices[currBuyIdx];
        }
        return totalProfit;
    }
}