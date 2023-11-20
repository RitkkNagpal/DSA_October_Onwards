import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern15(n);
        scn.close();
    }

    private static void printPattern15(int n) {
        int str = 1;
        int spc = n / 2;
        int rowStartVal = 1;
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < spc; j++) {
                System.out.print("\t");
            }
            // stars
            int colVal = rowStartVal;
            for (int j = 0; j < str; j++) {
                System.out.print(colVal + "\t");
                if (j >= str / 2) {
                    colVal--;
                } else {
                    colVal++;
                }
            }
            System.err.println();
            if (i >= n / 2) {
                str -= 2;
                spc++;
                rowStartVal--;
            } else {
                str += 2;
                spc--;
                rowStartVal++;
            }
        }
    }
}
