import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }
        int maxProfit = buySellStocksOneTransaction(prices);
        System.out.println(maxProfit);
        scn.close();
    }

    private static int buySellStocksOneTransaction(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int max = 0;
        int pist = 0; // profit if sold today
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            pist = prices[i] - min;
            max = Math.max(pist, max);
        }
        return max;
    }
}