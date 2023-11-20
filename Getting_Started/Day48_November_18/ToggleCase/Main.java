import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String toggledCaseString = toggleCase(str);
        System.out.println(toggledCaseString);
        scn.close();
    }

    private static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch += 32;
            } else if (ch >= 97 && ch <= 122) {
                ch -= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
