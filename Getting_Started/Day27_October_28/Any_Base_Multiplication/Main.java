import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int prod = anyBaseMultiplication(b, n1, n2);
        System.out.println(prod);
        scn.close();
    }

    private static int anyBaseMultiplication(int b, int n1, int n2) {
        int ans = 0;
        int pow = 1;
        while (n2 > 0) {
            int ld = n2 % 10;
            n2 /= 10;
            int singleDigitMultiplicationRes = singleDigitMultiplication(b, n1, ld);
            ans = anyBaseAddition(b, ans, (singleDigitMultiplicationRes * pow));
            pow *= 10;
        }
        return ans;
    }

    private static int singleDigitMultiplication(int b, int n, int d) {
        int ans = 0;
        int carry = 0;
        int pow = 1;
        while (n > 0 || carry > 0) {
            int ld = n % 10;
            n /= 10;
            int mulVal = (ld * d) + carry;
            int rem = mulVal % b;
            carry = mulVal / b;
            ans += (rem * pow);
            pow *= 10;
        }
        return ans;
    }
    
    private static int anyBaseAddition(int b, int n1, int n2) {
        int pow = 1;
        int ans = 0;
        int carry = 0;
        while (n1 > 0 || n2 > 0 || carry > 0) {
            int ld1 = n1 % 10;
            int ld2 = n2 % 10;

            int val = ld1 + ld2 + carry; // 4
            int rem = val % b;
            carry = val / b;
            ans += (rem * pow);

            n1 /= 10;
            n2 /= 10;
            pow *= 10;
        }
        return ans;
    }
}