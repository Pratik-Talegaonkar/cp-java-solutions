import java.util.Scanner;

public class SequenceDecreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int zeroCount = 0;
            int minVal = Integer.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val == 0) {
                    zeroCount++;
                } else {
                    if (val < minVal) {
                        minVal = val;
                    }
                }
            }
            
            int ans = 0;
            if (zeroCount > 0) {
                // Case 1: Contains at least one zero -> Full array length n is possible
                ans = n;
            } else {
                // Case 2: Purely positive numbers -> Check if we have enough elements to reduce the minimum value
                if (n >= minVal + 1) {
                    ans = n;
                } else {
                    ans = 0;
                }
            }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb.toString());
        sc.close();
    }
}
