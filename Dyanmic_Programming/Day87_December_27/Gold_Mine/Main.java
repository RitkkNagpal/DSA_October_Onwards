import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] gold = new int[n][m];
        for (int i = 0; i < gold.length; i++) {
            for (int j = 0; j < gold[0].length; j++) {
                gold[i][j] = scn.nextInt();
            }
        }
        int maxGold = goldMine(gold);
        System.out.println(maxGold);
        scn.close();
    }

    private static int goldMine(int[][] gold) {
        int n = gold.length;
        int m = gold[0].length;
        int[][] dp = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = gold[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + gold[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j + 1], dp[i][j + 1]) + gold[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j + 1], Math.max(dp[i - 1][j + 1], dp[i][j + 1])) + gold[i][j];
                }
            }
        }

        int colMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            colMax = Math.max(colMax, dp[i][0]);
        }
        return colMax;
    }
}
