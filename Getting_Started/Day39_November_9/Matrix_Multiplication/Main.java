import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] mat1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                mat1[i][j] = scn.nextInt();
            }
        }
        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int[][] mat2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                mat2[i][j] = scn.nextInt();
            }
        }

        int[][] resultantMatrix = multiply(mat1, mat2);
        display(resultantMatrix);
        scn.close();
    }

    private static int[][] multiply(int[][] mat1, int[][] mat2) {
        int n1 = mat1.length;
        int n2 = mat1[0].length;
        int m1 = mat2.length;
        int m2 = mat2[0].length;
        int[][] resultantMatrix = new int[n1][m2];
        for (int i = 0; i < resultantMatrix.length; i++) {
            for (int j = 0; j < resultantMatrix[0].length; j++) {
                for (int k = 0; k < n2; k++) {
                    resultantMatrix[i][j] += (mat1[i][k] * mat2[k][j]);
                }
            }
        }

        return resultantMatrix;
    }

    private static void display(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}