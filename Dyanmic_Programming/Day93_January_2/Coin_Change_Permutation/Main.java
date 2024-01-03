import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] denominations = new int[n];
        for (int i = 0; i < denominations.length; i++) {
            denominations[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int ans = coinChangePermutation(denominations, target);
        System.out.println(ans);
        scn.close();
    }

    private static int coinChangePermutation(int[] denominations, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int denomination : denominations) {
                if (denomination <= i) {
                    dp[i] += dp[i - denomination];
                }
            }
        }
        return dp[target];
    }
}