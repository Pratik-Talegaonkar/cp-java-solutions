import java.util.*;

public class TableWithNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int h = sc.nextInt();
            int l = sc.nextInt();
            
            int countH = 0; 
            int countL = 0;
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a <= h) countH++;
                if (a <= l) countL++;
            }
            int usable = Math.max(countH, countL);
            int answer = Math.min(Math.min(countH, countL), usable / 2);
            
            System.out.println(answer);
        }
        
        sc.close();
    }
}
