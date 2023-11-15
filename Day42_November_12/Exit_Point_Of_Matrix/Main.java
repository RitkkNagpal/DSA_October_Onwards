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
        printExitPoints(mat);
        scn.close();
    }

    private static void printExitPoints(int[][] mat) {
        int i = 0;
        int j = 0;
        int n = mat.length - 1;
        int m = mat[0].length - 1;

        int sum = 0;
        while (true) {
            sum = (sum + mat[i][j]) % 4;
            switch (sum) {
                case 0:
                    j++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    j--;
                    break;
                case 3:
                    i--;
                    break;
                default:// nothing
            }
            if (i < 0) {
                i++;
                break;
            } else if (j < 0) {
                j++;
                break;

            } else if (i == n + 1) {
                i--;
                break;

            } else if (j == m + 1) {
                j--;
                break;

            }
        }
        System.out.println(i);
        System.out.println(j);
    }
}
