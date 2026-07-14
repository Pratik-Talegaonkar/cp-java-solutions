import java.util.Scanner;

public class NikitaAndBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int a[] = new int[n];
            long prefix = 0;
            long sum = 0;
            boolean ans = true;
            for(int i = 0 ; i < n ; i++) {
                a[i] = in.nextInt();
                sum += i + 1;
                prefix += a[i];
                if(prefix < sum) {
                    ans = false;
                }
            }
            System.out.println((ans)?"YES":"NO");

        }
        in.close();
    }
}
