import java.util.ArrayList;
import java.util.List;
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

        List<Integer> matrixOrder = getSpiralMatrixOrder(mat);
        display(matrixOrder);
        scn.close();
    }

    private static List<Integer> getSpiralMatrixOrder(int[][] mat) {
        int rowStart = 0;
        int rowEnd = mat.length - 1;
        int colStart = 0;
        int colEnd = mat[0].length - 1;
        int eleCount = mat.length * mat[0].length;
        List<Integer> resList = new ArrayList<>();
        while (resList.size() < eleCount) {
            for (int i = rowStart; i <= rowEnd && resList.size() < eleCount; i++) {
                resList.add(mat[i][colStart]);
            }
            colStart++;
            for (int i = colStart; i <= colEnd && resList.size() < eleCount; i++) {
                resList.add(mat[rowEnd][i]);
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart && resList.size() < eleCount; i--) {
                resList.add(mat[i][colEnd]);
            }
            colEnd--;
            for (int i = colEnd; i >= colStart && resList.size() < eleCount; i--) {
                resList.add(mat[rowStart][i]);
            }
            rowStart++;
        }
        return resList;
    }

    private static void display(List<Integer> mat) {
        for (int ele : mat) {
            System.out.print(ele + "\t");
        }
    }
}