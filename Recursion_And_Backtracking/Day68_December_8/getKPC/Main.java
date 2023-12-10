import java.util.Scanner;

public class Main {
    private static final String[] CODES = {
            ".;",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tu",
            "vwx",
            "yz"
    };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printKPC(str, "");
        scn.close();
    }

    private static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String remstr = str.substring(1);
        String code = CODES[ch - '0'];
        for (char chr : code.toCharArray()) {
            printKPC(remstr, ans + chr);
        }
    }
}
