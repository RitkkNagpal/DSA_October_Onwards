import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt(); // starting i
        int c = scn.nextInt(); // starting j
        int[][] chess = new int[n][n];
        knightsTour(chess, r, c, 1);
        scn.close();
    }

    private static void knightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] != 0) {
            return;
        } else if (upcomingMove == (chess.length * chess.length)) {
            chess[r][c] = upcomingMove;
            display(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = upcomingMove;
        knightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        knightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        knightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        knightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        knightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        knightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        knightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        knightsTour(chess, r - 2, c - 1, upcomingMove + 1);
        chess[r][c] = 0;
    }

    private static void display(int[][] chess) {
        for (int[] row : chess) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
