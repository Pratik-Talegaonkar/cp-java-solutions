import java.util.Arrays;
import java.util.Scanner;

public class BalancedRound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int inter = 0;
            int maxInter = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] > k) {
                    inter = 0;
                    continue;
                }
                inter++;
                maxInter = Math.max(maxInter, inter);
            }
            System.out.println(n - maxInter - 1);
        }
        in.close();
    }
}