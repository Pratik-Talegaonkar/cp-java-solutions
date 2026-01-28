import java.util.*;

public class LongestDivisorsInterval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long ans = 0;
            while (n % ans == 0) {
                ans++;
            }
            System.out.println(ans);
        }
        in.close();
    }
}