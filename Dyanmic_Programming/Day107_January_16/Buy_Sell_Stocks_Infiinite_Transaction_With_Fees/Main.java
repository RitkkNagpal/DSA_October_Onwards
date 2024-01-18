import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        int fees = scn.nextInt();
        int maxProfit = buySellStocksInfiniteTransactionWithFees(prices, fees);
        System.out.println(maxProfit);
        scn.close();
    }

    private static int buySellStocksInfiniteTransactionWithFees(int[] prices, int fees) {
        int bsp = -prices[0]; // buy state profit
        int ssp = 0;
        for (int i = 1; i < prices.length; i++) {
            int nbsp = ssp - prices[i]; // new buy state profit.
            int nssp = prices[i] + bsp - fees; // new sell state profit.

            bsp = Math.max(nbsp, bsp);
            ssp = Math.max(nssp, ssp);
        }
        return ssp;
    }

}
