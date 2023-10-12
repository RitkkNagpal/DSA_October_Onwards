import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern12(n);
        scn.close();
    }

    private static void printPattern12(int n) {
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(fib(num) + "\t");
                num++;
            }
            System.out.println();
        }
    }

    private static int fib(int num)  {
        int a = -1;
        int b = 1;
        for(int i = 0; i < num; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
