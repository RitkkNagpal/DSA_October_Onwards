import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scn.nextInt();
        }
        int minMoves = climbStairsMinMoves(steps);
        System.out.println(minMoves);
        scn.close();
    }

    private static int climbStairsMinMoves(int[] steps) {
        int n = steps.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int jump = 1; jump <= steps[i] && i + jump < dp.length; jump++) {
                min = Math.min(min, dp[i + jump]);
            }
            if (min != Integer.MAX_VALUE) {
                min = min + 1;
            }
            dp[i] = min;
        }
        return dp[0];
    }
}