import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationSwap {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                int p = Integer.parseInt(st.nextToken());
                int diff = Math.abs(p - i);
                
                if (diff != 0) {
                    ans = gcd(ans, diff);
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}