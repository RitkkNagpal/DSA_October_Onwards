import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        long maxProfitWithCoolDown = buySellStocksCoolDown(prices);
        System.out.println(maxProfitWithCoolDown);
        scn.close();
    }

    private static long buySellStocksCoolDown(int[] prices) {
        long bsp = -prices[0]; // buy state profit
        long ssp = 0; // sell state profit
        long sspc = 0; // sell state profit cooldown

        for (int i = 1; i < prices.length; i++) {
            long nbsp = sspc - prices[i];
            long nssp = prices[i] + bsp;
            long nsspc = ssp;

            bsp = Math.max(bsp, nbsp);
            ssp = Math.max(ssp, nssp);
            sspc = Math.max(sspc, nsspc);
        }
        return ssp;
    }
}