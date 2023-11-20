import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern19(n);
        scn.close();
    }

    private static void printPattern19(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j <= n / 2) || (i == n - 1 && j >= n / 2)) {
                    System.out.print("*\t");
                } else if (i == n / 2 || j == n / 2) {
                    System.out.print("*\t");
                } else if ((j == 0 && i >= n / 2) || (j == n - 1 && i <= n / 2)) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
