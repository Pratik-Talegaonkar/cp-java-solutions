import java.util.Scanner;

public class LutnikAndSubsequences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int noOfZeros = 0, noOfOnes = 0;
            
            int a[] = new int[n];
            for(int i = 0 ; i < n ; i++) {
                a[i] = in.nextInt();
                if(a[i] == 0)
                    noOfZeros += 1;
                if(a[i] == 1)
                    noOfOnes += 1;
            }

            long ans = (long)Math.pow(2,noOfZeros) * noOfOnes;
            System.out.println(ans);
        }
        in.close();
    }
}
