import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern17(n);
        scn.close();
    }

    private static void printPattern17(int n) {
        int spc = n / 2;
        int str = 1;
        for (int i = 0; i < n; i++) {
            // print spaces
            for (int j = 0; j < spc; j++) {
                if (i != n / 2) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            // print stars
            for (int j = 0; j < str; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            if (i >= n / 2) {
                str--;
            } else {
                str++;
            }
        }
    }
}
