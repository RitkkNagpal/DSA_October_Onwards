import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scn.nextInt();
        }
        int ways = climbStairsVariableJumps(steps);
        System.out.println(ways);
        scn.close();
    }

    private static int climbStairsVariableJumps(int[] steps) {
        int[] dp = new int[steps.length + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j <= steps[i] && i + j < dp.length; j++) {
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }

}