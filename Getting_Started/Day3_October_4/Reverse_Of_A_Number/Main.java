import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        boolean isNegative = false;
        if (num < 0)
            isNegative = true;
        if (isNegative)
            num = num * -1;
        long rev = reverse(num);
        if (isNegative)
            rev = rev * -1;
        System.out.println(rev);
    }

    private static long reverse(long num) {
        long rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
