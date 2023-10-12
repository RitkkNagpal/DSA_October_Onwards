import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num1 = scn.nextLong();
        long num2 = scn.nextLong();
        long gcd = findGCD(num1,num2);
        long lcm = (num1*num2)/gcd;
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
        scn.close();
    }

    private static long findGCD(long num1, long num2) {
        while(num1 % num2 != 0) {
            long rem = num1 % num2;
            System.out.println(rem);
            num1 = num2;
            num2 = rem;
        }
        return num2;
    }
}
