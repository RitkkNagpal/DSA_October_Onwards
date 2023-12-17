import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        floodFill(mat, 0, 0, n, m, "");
    }

    private static void floodFill(int[][] maze, int i, int j, int n, int m, String asf) {
        if (i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == 1) {
            return;
        }
        if (i == n - 1 && j == m - 1) {
            System.out.println(asf);
            return;
        }
        maze[i][j] = 1;
        // top
        floodFill(maze, i - 1, j, n, m, asf + "t");
        // Left
        floodFill(maze, i, j - 1, n, m, asf + "l");
        // down
        floodFill(maze, i + 1, j, n, m, asf + "d");
        // top
        floodFill(maze, i, j + 1, n, m, asf + "r");
        maze[i][j] = 0;
    }
}