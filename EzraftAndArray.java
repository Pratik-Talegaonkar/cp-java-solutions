import java.util.Scanner;

public class EzraftAndArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();

            if (n == 1) {
                sb.append(1).append("\n");
            } else if (n == 2) {
                sb.append(-1).append("\n");
            } else {
                long[] a = new long[n];
                a[0] = 1;
                a[1] = 2;
                a[2] = 3;
                for (int i = 3; i < n; i++) {
                    a[i] = a[i - 1] * 2;
                }
                for (int i = 0; i < n; i++) {
                    sb.append(a[i]);
                    if (i < n - 1) sb.append(' ');
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
        sc.close();
    }
}