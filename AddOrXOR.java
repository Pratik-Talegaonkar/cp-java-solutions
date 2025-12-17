import java.util.Scanner;
public class AddOrXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            if (a > b) {
                System.out.println(-1);
                continue;
            }
            if (a == b) {
                System.out.println(0);
                continue;
            }

            // Since a, b <= 100, we can use simple BFS or DP.
            // Let's use DP: dp[val] = min cost to reach val from a
            int[] dp = new int[105];
            for (int i = 0; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
            dp[a] = 0;

            java.util.Queue<Integer> queue = new java.util.LinkedList<>();
            queue.add(a);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (curr + 1 <= b && dp[curr + 1] > dp[curr] + x) {
                    dp[curr + 1] = dp[curr] + x;
                    queue.add(curr + 1);
                }
                int xor = curr ^ 1;
                if (xor <= b && dp[xor] > dp[curr] + y) {
                    dp[xor] = dp[curr] + y;
                    queue.add(xor);
                }
            }

            System.out.println(dp[b] == Integer.MAX_VALUE ? -1 : dp[b]);
        }
        in.close();
    }
}