import java.util.Scanner;

public class ComparisonString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            int maxLen = 1;
            int currentLen = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currentLen++;
                } else {
                    maxLen = Math.max(maxLen, currentLen);
                    currentLen = 1;
                }
            }
            maxLen = Math.max(maxLen, currentLen);
            System.out.println(maxLen + 1);
        }
        /*
         * the minimum cost is simply the length of the longest
         * contiguous segment of identical characters plus 1.
         */
        in.close();
    }
}