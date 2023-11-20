import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        if (n1 > n2) {
            System.out.println(anyBaseSubtraction(b, n1, n2));
        } else {
            System.out.println(anyBaseSubtraction(b, n2, n1));
        }
        scn.close();
    }

    private static int anyBaseSubtraction(int b, int n1, int n2) {
        int ans = 0;
        int pow = 1;
        int borrow = 0;
        while (n1 > 0) {
            int ld1 = n1 % 10;
            int ld2 = n2 % 10;

            int val = ld1 - ld2 + borrow;
            if (val < 0) {
                val += b;
                borrow = -1;
            } else {
                borrow = 0;
            }
            ans += val * pow;
            pow = pow * 10;
            n1 /= 10;
            n2 /= 10;
        }
        return ans;
    }
}
