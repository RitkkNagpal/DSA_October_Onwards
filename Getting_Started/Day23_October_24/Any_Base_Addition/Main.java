import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long b = scn.nextLong();
        long n1 = scn.nextLong();
        long n2 = scn.nextLong();
        long val = anyBaseAddition(b, n1, n2);
        System.out.println(val);
        scn.close();
    }

    private static long anyBaseAddition(long b, long n1, long n2) {
        long ans = 0;
        long pow = 1;
        int carry = 0;
        while (n1 > 0 || n2 > 0 || carry > 0) {
            long ld1 = 0;
            if (n1 > 0) {
                ld1 = n1 % 10;
                n1 /= 10;
            }
            long ld2 = 0;
            if (n2 > 0) {
                ld2 = n2 % 10;
                n2 /= 10;
            }

            long val = ld1 + ld2 + carry;
            ans += (pow * (val % b));
            carry = (int) (val / b);
            pow *= 10;
        }
        return ans;
    }
}