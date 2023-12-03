import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fact = factorial(n);
        System.out.println(fact);
        scn.close();
    }

    private static int factorial(int n) {
        if (n == 1)
            return 1;

        return n * factorial(n - 1);
    }
}
