import java.util.Scanner;

public class MakeItIncreasing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            for(int i = 0 ; i < n ; i++) {
                a[i] = in.nextLong();
            }

            long count = 0;
            for(int i = n - 2 ; i >= 0 ; i--) {
                while(a[i+1] <= a[i] && a[i] != 0) {
                    a[i] /= 2;
                    count++;
                }
                if(a[i] == 0 && a[i+1] == 0) {
                    count = -1;
                    break;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
