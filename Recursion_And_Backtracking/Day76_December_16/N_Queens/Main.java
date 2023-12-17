import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, 0, "");
        scn.close();
    }

    private static void printNQueens(int[][] chess, int idx, String asf) {
        if (idx == chess.length) {
            System.out.println(asf);
            return;
        }
        for (int c = 0; c < chess.length; c++) {
            if (isSafeToPlaceQueen(chess, idx, c)) {
                chess[idx][c] = 1;
                printNQueens(chess, idx + 1, asf + idx + "-" + c + ",");
                chess[idx][c] = 0;
            }
        }
    }

    private static boolean isSafeToPlaceQueen(int[][] chess, int idx, int c) {
        // vertifcally up check
        for (int i = idx; i >= 0; i--) {
            if (chess[i][c] == 1) {
                return false;
            }
        }
        // diagonally up left
        for (int i = idx, j = c; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // diagonally up right
        for (int i = idx, j = c; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
