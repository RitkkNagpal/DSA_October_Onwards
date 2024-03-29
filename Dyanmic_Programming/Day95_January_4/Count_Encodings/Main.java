import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int ans = countEncondings(str);
        System.out.println(ans);
        scn.close();
    }

    private static int countEncondings(String str) {
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = dp[i - 1];
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i] + (i >= 2 ? dp[i - 2] : 1);
                }
            }
        }
        return dp[str.length() - 1];
    }
}