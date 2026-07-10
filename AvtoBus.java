import java.util.Scanner;

public class AvtoBus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            long n = in.nextLong();
            if(n < 4 || n % 2 != 0) {
                System.out.println(-1);
                continue;
            }
            
            long max = n/4;
            long min = (n+5)/6;
            System.out.println(min + " " + max);
        }
        in.close();
    }
}