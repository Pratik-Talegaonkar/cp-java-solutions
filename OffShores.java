import java.util.Scanner;

public class OffShores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long[] a = new long[n];
            long totalTransferable = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                totalTransferable += (a[i] / x) * y;
            }

            long maxAmount = 0;
            for (int i = 0; i < n; i++) {
                long current = a[i] + totalTransferable - (a[i] / x) * y;
                if (current > maxAmount) {
                    maxAmount = current;
                }
            }
            System.out.println(maxAmount);
        }
        sc.close();
    }
}
