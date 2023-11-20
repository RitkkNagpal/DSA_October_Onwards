import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String compressedString1 = compression1(str);
        String compressedString2 = compression2(str);
        System.out.println(compressedString1);
        System.out.println(compressedString2);
        scn.close();
    }

    private static String compression1(String str) {
        int[] cArray = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            cArray[ch - 'a']++;
        }

        StringBuilder compressedStringBuilder = new StringBuilder();
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] > 0) {
                compressedStringBuilder.append((char) ('a' + i));
            }
        }
        return compressedStringBuilder.toString();
    }

    private static String compression2(String str) {
        int i = 0, j = 0;
        StringBuilder compressedStringBuilder = new StringBuilder();
        while (true) {
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            char ch = str.charAt(i);
            compressedStringBuilder.append(ch);
            int diff = j - i;
            if (diff > 1) {
                compressedStringBuilder.append(diff);
            }
            if (j == str.length()) {
                break;
            } else {
                // characters are unequal
                i = j;
            }
        }
        return compressedStringBuilder.toString();
    }
}