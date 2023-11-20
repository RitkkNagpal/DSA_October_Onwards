import java.util.Scanner;
public class Main {
    private static int countDigits(long num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    private static void printDigits(long num, int div) {
        long pow = 1;
        for (int i = 0; i < div; i++) {
            pow = pow * 10;
        }
        while (num > 0) {
            System.out.println(num/pow);
            num =  num % pow;
            pow /= 10;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        int countDigits = countDigits(num);
        printDigits(num, countDigits - 1);
    }
}