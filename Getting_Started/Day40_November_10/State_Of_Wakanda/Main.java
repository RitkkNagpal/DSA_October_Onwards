import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        solveStateOfWakanda(mat);
        scn.close();
    }

    private static void solveStateOfWakanda(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int col = 0; col < m; col++) {
            // go down if even col
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    System.out.println(mat[row][col] + "\t");
                }
            } else {
                // go up if odd col
                for (int row = n - 1; row >= 0; row--) {
                    System.out.println(mat[row][col] + "\t");
                }
            }
            System.out.println();
        }
    }
}