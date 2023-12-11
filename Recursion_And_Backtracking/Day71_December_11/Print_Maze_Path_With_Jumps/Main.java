import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePathWithJumps(0, 0, n, m, "");
        scn.close();
    }

    private static void printMazePathWithJumps(int i, int j, int n, int m, String psf) {
        if (i == n || j == m) {
            return;
        }

        if (i == n - 1 && j == m - 1) {
            System.out.println(psf);
            return;
        }

        for (int jump = 1; j + jump <= m; jump++) {
            printMazePathWithJumps(i, j + jump, n, m, psf + "h" + jump);
        }
        for (int jump = 1; i + jump <= n; jump++) {
            printMazePathWithJumps(i + jump, j, n, m, psf + "v" + jump);
        }
        for (int jump = 1; i + jump <= n && j + jump <= m; jump++) {
            printMazePathWithJumps(i + jump, j + jump, n, m, psf + "d" + jump);
        }
    }
}
