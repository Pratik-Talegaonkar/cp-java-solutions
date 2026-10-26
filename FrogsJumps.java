import java.io.*;

public class FrogsJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String top = br.readLine().trim();
            String bottom = br.readLine().trim();

            int cntTop = 0, cntBottom = 0;
            for (int i = 0; i < n; i++) {
                if (top.charAt(i) == 'f') cntTop++;
                if (bottom.charAt(i) == 'f') cntBottom++;
            }

            if (cntTop == cntBottom) {
                out.append(0).append('\n');
                continue;
            }

            String majority;
            int D;
            if (cntTop > cntBottom) {
                majority = top;
                D = cntTop - cntBottom;
            } else {
                majority = bottom;
                D = cntBottom - cntTop;
            }

            int M = 0;
            for (int i = 0; i < n - 1; ) {
                if (majority.charAt(i) == 'f' && majority.charAt(i + 1) == 'f') {
                    M++;
                    i += 2;
                } else {
                    i++;
                }
            }

            int q = Math.min(M, D / 2);
            int answer = D - 2 * q;
            out.append(answer).append('\n');
        }

        System.out.print(out);
    }
}