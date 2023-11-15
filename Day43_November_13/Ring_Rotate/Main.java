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

        int s = scn.nextInt();
        int r = scn.nextInt();
        ringRotate(mat, s, r);
        display(mat);
    }

    private static void ringRotate(int[][] mat, int s, int r) {
        int[] requiredShell = getOneDArrayOfTheRequiredShell(mat, s);
        rotateArray(requiredShell, r);
        fillRotatedOneDArrayIntoMatrix(mat, requiredShell, s);
    }

    private static int[] getOneDArrayOfTheRequiredShell(int[][] mat, int s) {
        int n = mat.length;
        int m = mat[0].length;
        int rowSp = s - 1;
        int rowEp = n - s;
        int colSp = s - 1;
        int colEp = m - s;

        int totalEle = (rowEp - rowSp + colEp - colSp) * 2;
        int[] arr = new int[totalEle];
        int i = 0;
        for (int j = rowSp; j <= rowEp; j++) {
            arr[i++] = mat[j][colSp];
        }
        colSp++;
        for (int j = colSp; j <= colEp; j++) {
            arr[i++] = mat[rowEp][j];
        }
        rowEp--;
        for (int j = rowEp; j >= rowSp; j--) {
            arr[i++] = mat[j][colEp];
        }
        colEp--;
        for (int j = colEp; j >= colSp; j--) {
            arr[i++] = mat[rowSp][j];
        }
        rowSp++;
        return arr;
    }

    private static void rotateArray(int[] arr, int r) {
        if (r > arr.length) {
            r = r % arr.length;
        }
        if (r == 0)
            return;
        if (r < 0)
            r += arr.length;

        reverse(arr, 0, arr.length - r - 1);
        reverse(arr, arr.length - r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void fillRotatedOneDArrayIntoMatrix(int[][] mat, int[] shell, int s) {
        int n = mat.length;
        int m = mat[0].length;
        int rowSp = s - 1;
        int rowEp = n - s;
        int colSp = s - 1;
        int colEp = m - s;

        int i = 0;
        for (int j = rowSp; j <= rowEp; i++, j++) {
            mat[j][colSp] = shell[i];
        }
        colSp++;
        for (int j = colSp; j <= colEp; i++, j++) {
            mat[rowEp][j] = shell[i];
        }
        rowEp--;
        for (int j = rowEp; j >= rowEp; i++, j--) {
            mat[j][colEp] = shell[i];
        }
        colEp--;
        for (int j = colEp; j >= colSp; i++, j--) {
            mat[rowSp][j] = shell[i];
        }
        rowSp++;
    }

    private static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
