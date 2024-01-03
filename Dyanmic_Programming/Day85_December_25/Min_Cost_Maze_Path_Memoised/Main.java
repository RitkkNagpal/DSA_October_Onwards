import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scn.nextInt();
            }
        }
        int minCost = minCostMazeTraversal(maze, 0, 0, n, m, new int[n][m]);
        System.out.println(minCost);
    }

    private static int minCostMazeTraversal(int[][] maze, int i, int j, int n, int m, int[][] qb) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1 && j == m - 1) {
            qb[i][j] = maze[i][j];
            return maze[i][j];
        }
        int minHCost = minCostMazeTraversal(maze, i, j + 1, n, m, qb);
        int minVCost = minCostMazeTraversal(maze, i + 1, j, n, m, qb);
        qb[i][j] = Math.min(minHCost, minVCost) + maze[i][j];
        return qb[i][j];
    }
}
