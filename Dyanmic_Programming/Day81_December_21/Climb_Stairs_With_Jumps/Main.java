import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            steps[i] = scn.nextInt();
        }
        int ways = climbStairsWithVariableJumps(n, steps, new int[n], 0);
        System.out.println(ways);
    }

    private static int climbStairsWithVariableJumps(int n, int[] steps, int[] qb, int idx) {
        if (idx > steps.length) {
            return 0;
        }
        if (idx == steps.length) {
            return 1;
        }
        if (qb[idx] != 0) {
            return qb[idx];
        }
        int jumps = steps[idx];
        int ways = 0;
        for (int i = 1; i <= jumps; i++) {
            ways += climbStairsWithVariableJumps(n - i, steps, qb, idx + i);
        }
        qb[idx] = ways;
        return ways;
    }
}