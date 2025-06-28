import java.util.Scanner;
public class WeNeedTheZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int xor = 0;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
                xor = xor ^ arr[i];
            }

            System.out.println((n % 2 == 0)? (xor == 0) ? 1 : -1 : xor );
        }
        in.close();
    }
}