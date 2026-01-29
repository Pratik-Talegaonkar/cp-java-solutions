import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Seats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            out.println(solve(n, s));
        }
        out.flush();
    }

    private static int solve(int n, String s) {
        int first1 = s.indexOf('1');
        if (first1 == -1) {
            return (n + 2) / 3;
        }

        int last1 = s.lastIndexOf('1');
        int added = 0;
        int count1 = 0;

        // Left boundary gap
        int leftGap = first1;
        added += (leftGap + 1) / 3;

        // Right boundary gap
        int rightGap = n - 1 - last1;
        added += (rightGap + 1) / 3;

        // Count existing 1s and process internal gaps
        count1++; // Count the first 1
        int lastPos = first1;

        for (int i = first1 + 1; i <= last1; i++) {
            if (s.charAt(i) == '1') {
                count1++;
                int gap = i - lastPos - 1;
                added += gap / 3;
                lastPos = i;
            }
        }

        return count1 + added;
    }
}
