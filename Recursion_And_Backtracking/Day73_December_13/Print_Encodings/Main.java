import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        if (str.charAt(0) == '0') {
            System.out.println("Invalid input. A string starting with 0 will not be passed.");
        }
        printEncoding(str, "");
        scn.close();
    }

    private static void printEncoding(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if (ch == '0')
            return;
        String remStr = str.substring(1);
        printEncoding(remStr, ans + ((char) ('a' + Integer.parseInt(ch + "") - 1)));

        if (str.length() >= 2) {
            String firstTwoChar = str.substring(0, 2);
            int numVal = Integer.parseInt(firstTwoChar);
            if (numVal > 26 || firstTwoChar.charAt(0) == '0') {
                return;
            }
            remStr = str.substring(2);
            printEncoding(remStr, ans + ((char) ('a' + numVal - 1)));
        }
    }
}
