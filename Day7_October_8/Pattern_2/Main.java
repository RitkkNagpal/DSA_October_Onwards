import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern2(n);
        scn.close();
    }

    private static void printPattern2(int n) {
        int str = n;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < str; j++) {
                System.out.print("* ");
            }
            System.out.println();
            str--;
        }
    }
}
