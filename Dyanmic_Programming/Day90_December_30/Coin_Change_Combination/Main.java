import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] denominations = new int[n];
        for (int i = 0; i < n; i++) {
            denominations[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        int combinations = coinChangeCombinations(denominations, target);
        System.out.println(combinations);
        scn.close();
    }

    private static int coinChangeCombinations(int[] denominations, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int denomination : denominations) {
            for (int i = denomination; i < dp.length; i++) {
                dp[i] += dp[i - denomination];
            }
        }
        return dp[target];
    }
}