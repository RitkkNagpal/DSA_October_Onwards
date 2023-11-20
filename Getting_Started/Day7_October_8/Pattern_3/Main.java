import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern3(n);
        scn.close();
    }

    private static void printPattern3(int n) {
        int spc = n - 1;
        int str = 1;
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < spc; j++) {
                System.out.print("  ");
            }
            // star
            for (int j = 0; j < str; j++) {
                System.out.print("* ");
            }
            System.out.println();
            spc--;
            str++;
        }
    }
}
