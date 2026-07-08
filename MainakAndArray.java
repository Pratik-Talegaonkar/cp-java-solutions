import java.util.Scanner;

public class MainakAndArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while(test-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int a1 = 0, a2 = 0, a3 = 0;
            for(int i = 0 ; i < n ; i++) {
                a[i] = in.nextInt();
            }

            for(int i = 0 ; i < n ; i++) {
                a1 = Math.max(a1, a[i] - a[0]);
                a2 = Math.max(a2, a[n-1] - a[i]);
                if(i > 0)
                    a3 = Math.max(a3, a[i] - a[i-1]); 
            }
                
            System.out.println(Math.max(a1, Math.max(a2, a3)));
        }
        in.close();
    }   
}
