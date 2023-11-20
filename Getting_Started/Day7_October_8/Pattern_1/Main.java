import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        printPattern(n);
        scn.close();
    }

    private static void printPattern(long n) {
        int str = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < str; j++) {
                System.out.print("* ");
            }
            str++;
            System.out.println();
        }
    }
}
