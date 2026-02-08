import java.io.*;

public class XORConvenience {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            int[] p = new int[n + 1];
            boolean[] used = new boolean[n + 1];

            p[n] = 1;
            used[1] = true;

            for (int i = 2; i <= n - 1; i++) {
                p[i] = 1 ^ i;// 
                used[p[i]] = true;
            }

            for (int v = 1; v <= n; v++) {
                if (!used[v]) {
                    p[1] = v;
                    break;
                }
            }

            for (int i = 1; i <= n; i++) {
                sb.append(p[i]);
                if (i < n)
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
