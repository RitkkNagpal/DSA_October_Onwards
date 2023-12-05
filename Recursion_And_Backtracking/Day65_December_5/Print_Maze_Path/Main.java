import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        List<String> paths = getMazePaths(0, 0, n, m);
        System.out.println(paths);
        scn.close();
    }

    private static List<String> getMazePaths(int r, int c, int n, int m) {
        if (r == n || c == m)
            return new ArrayList<>();

        if (r == n - 1 && c == m - 1) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        List<String> hPaths = getMazePaths(r, c + 1, n, m);
        List<String> vPaths = getMazePaths(r + 1, c, n, m);
        List<String> res = new ArrayList<>();

        for (String path : hPaths) {
            res.add("h" + path);
        }
        for (String path : vPaths) {
            res.add("v" + path);
        }
        return res;
    }
}
