import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern16(n);
        scn.close();
    }

    private static void printPattern16(int n) {
        int str = 1;
        int spc = (2 * n) - 3;
        for(int i = 0; i < n; i++) {
            int val = 1;
            // str
            for(int j = 0; j < str; j++) {
                System.out.print(val++ + "\t");
            }

            // spc
            for(int j = 0; j < spc; j++) {
                System.out.print("\t");
            }

            if(i == n-1) {
                str--;
                val--;
            }
            // str
            for(int j = 0; j < str; j++) {
                System.out.print(--val + "\t");
            }
            System.out.println();
            val++;
            str++;
            spc-=2;
        }
    }
}
