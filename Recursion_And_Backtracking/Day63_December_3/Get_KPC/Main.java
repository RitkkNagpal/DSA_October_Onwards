import java.util.ArrayList;
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
        String str = scn.next();
        ArrayList<String> strings = getKPC(str);
        System.out.println(strings);
        scn.close();
    }

    private static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String remStr = str.substring(1);
        ArrayList<String> codesFromRemString = getKPC(remStr);
        ArrayList<String> resultList = new ArrayList<>();
        for (char chr : CODES[ch - '0'].toCharArray()) {
            for (String code : codesFromRemString) {
                resultList.add(chr + code);
            }
        }
        return resultList;
    }
}