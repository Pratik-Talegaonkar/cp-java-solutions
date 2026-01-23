import java.util.*;

public class MakeItZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            boolean allZero = true;
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] != 0) allZero = false;
            }
            
            if (allZero) {
                System.out.println(0);
                continue;
            }
            
            if (n % 2 == 0) {
                System.out.println(2);
                System.out.println("1 " + n);
                System.out.println("1 " + n);
            } else {
                System.out.println(4);
                System.out.println("1 " + n);
                System.out.println("1 " + (n - 1));
                System.out.println("2 " + n);
                System.out.println("2 " + n);
            }
        }
        
        sc.close();
    }
}
