import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        boolean isTargetSumSubsetAvailable = targetSumSubset(arr, tar);
        System.out.println(isTargetSumSubsetAvailable);
    }

    private static boolean targetSumSubset(int[] arr, int tar) {
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        display(dp);
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][tar] == true) {
                return true;
            }
        }
        return false;
    }

    private static void display(boolean[][] dp) {
        for (boolean[] eles : dp) {
            for (boolean ele : eles) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }

}