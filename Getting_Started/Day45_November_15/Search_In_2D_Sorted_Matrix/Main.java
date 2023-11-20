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
        int ele = scn.nextInt();
        int[] indices = findInSorted2DArray(mat, ele);
        if (indices[0] != -1) {
            System.out.println(indices[0]);
            System.out.println(indices[1]);
        } else {
            System.out.println("Not Found");
        }
        scn.close();
    }

    private static int[] findInSorted2DArray(int[][] mat, int target) {
        int i = 0;
        int j = mat[0].length - 1;
        while (i < mat.length && j >= 0) {
            if (mat[i][j] == target) {
                return new int[] { i, j };
            } else if (mat[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] { -1, -1 };
    }
}
