import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern18(n);
        scn.close();
    }

    private static void printPattern18(int n) {
        int str = n;
        int spc = 0;
        for (int i = 0; i < n; i++) {
            // spc
            for (int j = 0; j < spc; j++) {
                System.out.print("\t");
            }
            // star
            for (int j = 0; j < str; j++) {
                if (i > 0 && i < n / 2 && j != 0 && j != str - 1) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
            if (i >= n / 2) {
                str += 2;
                spc -= 1;
            } else {
                str -= 2;
                spc += 1;
            }
        }
    }
}