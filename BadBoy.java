import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class BadBoy {
    public static void main(String[] args) throws IOException{
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long i = sc.nextLong();
            long j = sc.nextLong();

            System.out.println(1 + " " + 1 + " " + n + " " + m);
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
