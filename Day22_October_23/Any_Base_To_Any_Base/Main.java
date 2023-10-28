import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        long b1 = scn.nextLong();
        long b2 = scn.nextLong();
        long val = anyBaseToAnyBaseConversion(n, b1, b2);
        System.out.println(val);
    }

    public static long anyBaseToAnyBaseConversion(long n, long b1, long b2) {
        long b1ToDecimal = anyBaseToDecimal(n, b1);
        return decimalToAnyBase(b1ToDecimal, b2);
    }

    public static long anyBaseToDecimal(long n, long b) {
        long ans = 0;
        long pow = 1;
        while (n > 0) {
            long ld = n % 10;
            ans += (ld * pow);
            pow *= b;
            n /= 10;
        }
        return ans;
    }

    public static long decimalToAnyBase(long n, long b) {
        long ans = 0;
        long pow = 1;
        while (n > 0) {
            long rem = n % b;
            n /= b;
            ans += (rem * pow);
            pow *= 10;
        }
        return ans;
    }
}
