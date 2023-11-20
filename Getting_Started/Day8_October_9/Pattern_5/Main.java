import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        printPattern5(num);
        scn.close();
    }

    private static void printPattern5(int num) {
        int str = 1;
        int spc = num / 2;
        for (int i = 0; i < num; i++) {
            // spaces
            for (int j = 0; j < spc; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j < str; j++) {
                System.out.print("* ");
            }

            System.out.println();
            if (i < num / 2) {
                spc--;
                str += 2;
            } else {
                spc++;
                str -=2;
            }
        }
    }
}