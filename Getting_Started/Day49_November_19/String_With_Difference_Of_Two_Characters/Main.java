import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String updatedStr = formStringWithDifferenceOfEveryTwoCharacters(str);
        System.out.println(updatedStr);
        scn.close();
    }

    private static String formStringWithDifferenceOfEveryTwoCharacters(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            sb.append((int) (curr - prev)).append(curr);
        }
        return sb.toString();
    }
}
