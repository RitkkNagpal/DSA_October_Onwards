import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern6(n);
        scn.close();
    }

    private static void printPattern6(int n) {
        int str = (n / 2) + 1;
        int spc = 1;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 0; j < str; j++) {
                System.out.print("* ");
            }

            // spaces
            for (int j = 0; j < spc; j++) {
                System.out.print("  ");
            }

            // stars
            for (int j = 0; j < str; j++) {
                System.out.print("* ");
            }
            System.out.println();
            if (i >= n / 2) {
                str++;
                spc -= 2;
            } else {
                spc += 2;
                str--;
            }
        }
    }
}
