import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        solveStateOfWakanda2(mat);
        scn.close();
    }

    private static void solveStateOfWakanda2(int[][] mat) {
        for (int d = 0; d < mat[0].length; d++) {
            for (int i = 0, j = d; j < mat[0].length; i++, j++) {
                System.out.println(mat[i][j]);
            }
        }
    }
}