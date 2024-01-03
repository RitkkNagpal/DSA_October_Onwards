import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ways = climbStairs(n, new int[n + 1]);
        System.out.println(ways);
        scn.close();
    }

    private static int climbStairs(int n, int[] qb) {
        if (n <= 0) {
            if (n == 0)
                return 1;
            return 0;
        }
        if (qb[n] != 0)
            return qb[n];
        int nm1 = climbStairs(n - 1, qb);
        int nm2 = climbStairs(n - 2, qb);
        int nm3 = climbStairs(n - 3, qb);
        int res = nm1 + nm2 + nm3;
        qb[n] = res;
        return res;
    }
}
