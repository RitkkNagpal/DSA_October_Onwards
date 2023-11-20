import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printAllPalindromicSubstrings(str);
        scn.close();
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right)
            return true;

        return false;
    }

    private static void printAllPalindromicSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String candidate = (str.substring(i, j + 1));
                if (isPalindrome(candidate)) {
                    System.out.println(candidate);
                }
            }
        }
    }
}