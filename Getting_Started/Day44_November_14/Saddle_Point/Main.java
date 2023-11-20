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

        int saddlePointVal = saddlePoint(mat);
        if (saddlePointVal != -1) {
            System.out.println(saddlePointVal);
        } else {
            System.out.println("InValid Input");
        }
        scn.close();
    }

    private static int saddlePoint(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            int lci = 0; // least column value index
            for(int j = 1; j < mat[0].length; j++) {
                if(mat[i][j] < mat[i][lci]) {
                    lci = j;
                }
            }

            int maxRowVal = mat[i][lci];
            boolean found = true;
            for(int j = 0; j < mat.length; j++) {
                if(mat[j][lci] > maxRowVal) {
                    found = false;
                    break;
                }
            }
            if(found == true) return maxRowVal;
        }
        return -1;
    }
}
