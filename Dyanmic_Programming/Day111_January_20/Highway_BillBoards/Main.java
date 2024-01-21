import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int countBillBoards = scn.nextInt();
        int[] positionsBillBoards = new int[countBillBoards];
        for (int i = 0; i < positionsBillBoards.length; i++) {
            positionsBillBoards[i] = scn.nextInt();
        }
        int[] revenueFromBillBoards = new int[countBillBoards];
        for (int i = 0; i < revenueFromBillBoards.length; i++) {
            revenueFromBillBoards[i] = scn.nextInt();
        }
        int gapBWBillBoard = scn.nextInt();
        int maxRevenue = calculateMaxRevenue(countBillBoards, positionsBillBoards, revenueFromBillBoards,
                gapBWBillBoard);
        System.out.println(maxRevenue);
        System.out.println(
                calculateMaxRevenue2(n, countBillBoards, positionsBillBoards, revenueFromBillBoards, gapBWBillBoard));
        scn.close();
    }

    private static int calculateMaxRevenue(int countBillBoards, int[] positionsBillBoards, int[] revenueFromBillBoards,
            int gapBWBillBoard) {
        int[] dp = new int[countBillBoards];
        dp[0] = revenueFromBillBoards[0];
        int overAllMax = 0;
        for (int i = 1; i < countBillBoards; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (positionsBillBoards[i] - positionsBillBoards[j] > gapBWBillBoard) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + revenueFromBillBoards[i];
            overAllMax = Math.max(overAllMax, dp[i]);
        }
        return overAllMax;
    }

    private static int calculateMaxRevenue2(int miles, int countBillBoards, int[] positionsBillBoards,
            int[] revenueFromBillBoards,
            int gapBWBillBoard) {
        int[] dp = new int[miles + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < countBillBoards; i++) {
            map.put(positionsBillBoards[i], revenueFromBillBoards[i]);
        }
        dp[0] = 0;
        for (int i = 1; i <= miles; i++) {
            if (map.containsKey(i)) {
                int boardNotInstalled = dp[i - 1];
                int boardInstalled = map.get(i) + (i >= gapBWBillBoard - 1 ? dp[i - gapBWBillBoard - 1] : 0);
                dp[i] = Math.max(boardNotInstalled, boardInstalled);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[miles];
    }
}