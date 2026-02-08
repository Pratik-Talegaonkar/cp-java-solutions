import java.util.Scanner;

public class LawnMower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long w = sc.nextLong();
            System.out.println(n - (n / w));
        }
        sc.close();
    }
}
