import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern13(n);
        scn.close();
    }

    private static void printPattern13(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(combination(i, j) + "\t");
            }
            System.out.println();
        }
    }

    private static int combination(int n, int r) {
        return (fact(n) / ((fact(r) * fact(n - r))));
    }

    private static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
