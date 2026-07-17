import java.util.Scanner;

public class WhoWatchesTheWatchpig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            
            if (n < 2 * k) {
                System.out.println("-1");
                continue;
            }
            int flips = 0;
            
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == 'L') {
                    flips++;
                }
            }
            
            for (int i = n - k; i < n; i++) {
                if (s.charAt(i) == 'R') {
                    flips++;
                }
            }
            
            System.out.println(flips);
        }
        
        sc.close();
    }
}
