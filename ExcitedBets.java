import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class ExcitedBets {
    public static void main(String[] args) throws IOException {
        FastScanner obj = new FastScanner();
        int t = obj.nextInt();
        while(t-- > 0) {
            long a = obj.nextLong();
            long b = obj.nextLong();

            if (b > a) {
				long temp = a;
				a = b;
				b = temp;
			}

			if (a == b) {
				System.out.println("0 0");
			} 
            else {
				System.out.println(a - b + " " + Math.min(b % (a-b), (a-b) - b % (a-b)));
            }
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); } 
    }
}
