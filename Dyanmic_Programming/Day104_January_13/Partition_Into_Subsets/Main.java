import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long ways = partitionIntoSubsets(n, k);
        System.out.println(ways);
        scn.close();
    }

    private static long partitionIntoSubsets(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];
        for (int teams = 1; teams <= k; teams++) {
            for (int people = 1; people <= n; people++) {
                if (people < teams) {
                    dp[teams][people] = 0;
                } else if (people == teams) {
                    dp[teams][people] = 1;
                } else {
                    dp[teams][people] = (teams * dp[teams][people - 1]) + (dp[teams - 1][people - 1]);
                }
            }
        }
        return dp[k][n];
    }
}
