import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern4(n);
        scn.close();
    }    

    private static void printPattern4(int n) {
        int str = n;
        int spc = 0;
        for(int i = 0; i < n; i++){
            // spaces
            for(int j = 0; j < spc; j++){
                System.out.print("  ");
            }

            // stars
            for(int j = 0; j < str; j++) {
                System.out.print("* ");
            }
            System.out.println();
            str--;
            spc++;
        }
    }
}
