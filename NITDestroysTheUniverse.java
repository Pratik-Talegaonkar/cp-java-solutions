import java.util.Scanner;

public class NITDestroysTheUniverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();

            int runs = 0;
            boolean inRun = false;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x != 0) {
                    if (!inRun) {
                        runs++;
                        inRun = true;
                    }
                } else {
                    inRun = false;
                }
            }

            int ans = (runs == 0) ? 0 : (runs == 1 ? 1 : 2);
            sb.append(ans).append('\n');
        }
        sc.close();
        System.out.print(sb);
    }
}