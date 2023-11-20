import java.util.Scanner;

public class Main {
    private static void printFibbonacciSeries(int num) {
        long a = -1;
        long b = 1;
        for(int i = 0; i < num; i++) {
            long c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        printFibbonacciSeries(num);
    }
}
