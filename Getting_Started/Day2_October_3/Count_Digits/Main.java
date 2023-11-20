import java.util.Scanner;

public class Main {
    private static int countDigits(long num) {
        int count = 0;
        while(num > 0) {
            num = num/10;
            count++;           
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        int numbDigits = countDigits(num);
        System.out.println(numbDigits);
    }
}
