import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        printInverse(num);
        scn.close();
    }

    private static void printInverse(long num) {
        int numbDigits = countDigits(num); // 8
        long pow = 1;
        for(int i = 0; i < numbDigits - 1; i++) {
            pow = pow * 10;
        }
        Double inv = 0.0;
        while(num > 0) {
            int index = numbDigits; 
            long val = num/pow; 
            inv = inv + index * Math.pow(10*1.0, (val-1)*1.0); 
            numbDigits--; 
            num = num % pow; 
            pow /=10; 
        }
        System.out.println(inv.intValue());
    }

    private static int countDigits(long num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }
}