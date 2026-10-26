
import java.util.Scanner;

public class SubsetSelecting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int ans = 0;
            
            int[] count = new int[n + 2];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val <= n + 1) {
                    count[val]++;
                }
            }
            
            
            int available = 0;
            
            for (int x = 0; x <= n + 1; x++) {
                if (count[x] < 1) {
                    ans = x;
                    break;
                }
                
                available += count[x];
                
                if (available < k) {
                    ans = x;
                    break;
                }
                
                available -= k;

                
            }
            
            System.out.println(ans);
        }
        
        
        sc.close();
    }
}
