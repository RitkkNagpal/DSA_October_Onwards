import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int subsequences = countAPlusBPlusCPlusSubsequences(str);
        System.out.println(subsequences);
        scn.close();
    }

    private static int countAPlusBPlusCPlusSubsequences(String str) {
        int countAPlusSubsequences = 0;
        int countAPlusBPlusSubsequences = 0;
        int countAPlusBPlusCPlusSubsequences = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                countAPlusSubsequences = (2 * countAPlusSubsequences) + 1;
            } else if (str.charAt(i) == 'b') {
                countAPlusBPlusSubsequences = (2 * countAPlusBPlusSubsequences) + countAPlusSubsequences;
            } else if (str.charAt(i) == 'c') {
                countAPlusBPlusCPlusSubsequences = (2 * countAPlusBPlusCPlusSubsequences)
                        + countAPlusBPlusSubsequences;
            }
        }
        return countAPlusBPlusCPlusSubsequences;
    }
}
