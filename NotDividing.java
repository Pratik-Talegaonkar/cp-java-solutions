import java.util.Scanner;
public class NotDividing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0 ; i < n ; i++) {
                a[i] = in.nextInt();
                if(a[i] == 1)
                    a[i] = 2; 
            }

            for(int i = 0 ; i < n - 1 ; i++) {
                if(a[i+1] % a[i] == 0) {
                    a[i+1] += 1;
                }
            }
                
            for(int num : a)
                System.out.println(num);

        }
        in.close();
    }
}
