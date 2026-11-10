import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class OddDivisor {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner();
        int t = in.nextInt();
        while(t-- > 0) {
            long n = in.nextLong();

            if ((n & (n-1)) == 0) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        String next() {
            while(st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
