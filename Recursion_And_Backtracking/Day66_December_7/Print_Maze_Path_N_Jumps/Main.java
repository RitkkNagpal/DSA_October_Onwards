import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        List<String> paths = printMazePathWithJumps(0, 0, n, m);
        System.out.println(paths);
        scn.close();
    }

    private static List<String> printMazePathWithJumps(int i, int j, int n, int m) {
        if (i >= n || j >= m)
            return new ArrayList<>();

        if (i == n - 1 && j == m - 1) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        List<String> res = new ArrayList<>();
        for (int jump = 1; jump <= n; jump++) {
            List<String> hPaths = printMazePathWithJumps(i + jump, j, n, m);
            for (String hPath : hPaths) {
                res.add("h" + jump + hPath);
            }
        }
        for (int jump = 1; jump <= m; jump++) {
            List<String> vPaths = printMazePathWithJumps(i, j + jump, n, m);
            for (String vPath : vPaths) {
                res.add("v" + jump + vPath);
            }
        }
        for (int jump = 1; jump <= n; jump++) {
            List<String> dPaths = printMazePathWithJumps(i + jump, j + jump, n, m);
            for (String dPath : dPaths) {
                res.add("d" + jump + dPath);
            }
        }
        return res;
    }

}