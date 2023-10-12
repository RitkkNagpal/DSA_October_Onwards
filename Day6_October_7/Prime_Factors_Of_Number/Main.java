import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        printPrimeFactors(num);
        scn.close();
    }

    private static void printPrimeFactors(long num) {
        for(int div = 2; div * div <= num; div++){
            while(num % div == 0) {
                num = num / div;
                System.out.print(div + " ");
            }
        }
        if(num != 1) {
            System.out.print(num);
        }
    }
}

