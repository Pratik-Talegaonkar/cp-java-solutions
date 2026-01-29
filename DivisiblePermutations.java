import java.util.Scanner;
import java.io.PrintWriter;

public class DivisiblePermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] ans = new int[n + 1];
            int left = 1;
            int right = n;

            for (int i = n; i >= 1; i--) {
                if ((n - i) % 2 == 0) {
                    ans[i] = left++;
                } else {
                    ans[i] = right--;
                }
            }

            for (int i = 1; i <= n; i++) {
                out.print(ans[i] + (i == n ? "" : " "));
            }
            out.println();
        }
        out.flush();
        scanner.close();
    }
}
