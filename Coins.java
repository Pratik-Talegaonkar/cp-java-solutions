import java.util.Scanner;
public class Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            long n = in.nextLong();//1
            long k = in.nextLong();//1

            if(n <= 1 && k > 1) {
                System.out.println("NO");
            }
            else if(n % 2 != 0 && k % 2 == 0) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
            }
        }
        in.close();
    }
}