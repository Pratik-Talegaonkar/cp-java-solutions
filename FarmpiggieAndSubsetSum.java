import java.util.Scanner;

public class FarmpiggieAndSubsetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            for(int i = 1 ; i <= n ; i+=2) {
                System.out.print((i+1) + " " + i + " ");
            }
        }
        in.close();
    }
}
