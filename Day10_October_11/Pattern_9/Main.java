
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern9(n);
        scn.close();
    }

    private static void printPattern9(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || i == n - 1 -j) {
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
