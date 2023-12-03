import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        long pow = powerLogarithmic(x, n);
        System.out.println(pow);
        scn.close();
    }

    private static long powerLogarithmic(int x, int n) {
        if (n == 0)
            return 1;
        long pnb2 = powerLogarithmic(x, n / 2);
        if (n % 2 == 0) {
            return pnb2 * pnb2;
        } else {
            return pnb2 * pnb2 * x;
        }
    }
}
