import java.util.Scanner;
public class JellyfishAndUndertale {
    public static void main(String args[]) {
        int t = in.nextInt();
        Scanner in = new Scanner(System.in);
        while(t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            b--;
            while(n != 0) {
                b += Math.min(a,in.nextInt()); 
                n--;
            }
            System.out.println(b);
        }
    }
}