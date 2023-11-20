import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        solveCuriousCaseOfBenjaminBulbs(num);
        scn.close();
    }

    private static void solveCuriousCaseOfBenjaminBulbs(long num) {
        for (int i = 1; i * i <= num; i++) {
            System.out.println(i * i);
        }
    }
}