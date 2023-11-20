import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern10(n);
        scn.close();
    }

    private static void printPattern10(int num) {
        int outSpc = num / 2;
        int midSpc = -1;
        for (int i = 0; i < num; i++) {
            // outer spaces
            for (int j = 0; j < outSpc; j++) {
                System.out.print("\t");
            }
            // star
            System.out.print("*\t");
            // middle spaces
            if (i != 0 && i != (num - 1)) {
                for (int j = 0; j < midSpc; j++) {
                    System.out.print("\t");
                }
                // star
                System.out.print("*\t");
            }

            System.out.println();
            if (i >= num / 2) {
                midSpc -= 2;
                outSpc += 1;
            } else {
                midSpc += 2;
                outSpc -= 1;
            }
        }
    }
}
