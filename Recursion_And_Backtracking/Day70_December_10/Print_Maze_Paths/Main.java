import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePath(0, 0, n, m, "");
        scn.close();
    }

    private static void printMazePath(int i, int j, int n, int m, String psf) {
        if (i == n || j == m)
            return;
        if (i == n - 1 && j == m - 1) {
            System.out.println(psf);
            return;
        }
        printMazePath(i, j + 1, n, m, psf + "h");
        printMazePath(i + 1, j, n, m, psf + "v");
    }
}
