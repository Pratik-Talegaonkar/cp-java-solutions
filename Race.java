import java.util.Scanner;
public class Race{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int a = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if(a > x && a > y) {
                System.out.println("YES");
            }
            else if(a < x && a < y) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}