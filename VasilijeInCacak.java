import java.util.Scanner;
public class VasilijeInCacak {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();
            long x = in.nextLong();

            long minSum = k*(k+1)/2;
            long maxSum = k/2*(2*n-k+1);

            if(minSum <= x && x <= maxSum) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}