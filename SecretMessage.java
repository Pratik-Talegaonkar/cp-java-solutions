import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] masks = new int[n];

        for (int i = 0; i < k; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                masks[j] |= (1 << (s.charAt(j) - 'a'));
            }
        }

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);

        for (int d : divisors) {
            StringBuilder pattern = new StringBuilder();
            boolean possible = true;
            for (int r = 0; r < d; r++) {
                int common = (1 << 26) - 1;
                for (int j = r; j < n; j += d) {
                    common &= masks[j];
                }
                if (common == 0) {
                    possible = false;
                    break;
                }
                int charIndex = Integer.numberOfTrailingZeros(common);
                pattern.append((char) ('a' + charIndex));
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                String pat = pattern.toString();
                int repeats = n / d;
                for (int m = 0; m < repeats; m++) {
                    result.append(pat);
                }
                System.out.println(result.toString());
                return;
            }
        }
    }
}
