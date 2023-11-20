import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPattern11(n);
        scn.close();
    }    

    private static void printPattern11(int n) {
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(num+"\t");
                num++;
            }
            System.out.println();
        }
    }
}
