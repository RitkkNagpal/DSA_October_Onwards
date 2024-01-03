import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int steps[] = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scn.nextInt();
        }
        int minMoves = climbStairsMinMoves(steps, 0, new int[n]);
        System.out.println(minMoves);
        scn.close();
    }

    private static int climbStairsMinMoves(int[] steps, int idx, int[] qb) {
        if (idx == steps.length) {
            return 0;
        }
        if (steps[idx] == 0) {
            return Integer.MAX_VALUE;
        }
        if (qb[idx] != 0) {
            return qb[idx];
        }
        int minMoves = Integer.MAX_VALUE;
        for (int jump = 1; jump <= steps[idx] && jump + idx <= steps.length; jump++) {
            minMoves = Math.min(climbStairsMinMoves(steps, idx + jump, qb), minMoves);
        }
        if (minMoves == Integer.MAX_VALUE) {
            qb[idx] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        } else {
            qb[idx] = minMoves + 1;
            return minMoves + 1;
        }
    }
}
