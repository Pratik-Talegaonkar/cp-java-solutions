import java.util.Scanner;
public class GrasshopperOnALine {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int x = in.nextInt();
            int k = in.nextInt();
            int Xc = x;
            int n = 0;
            while (Xc % k == 0) {
                n++;
                Xc--;
            }
            System.out.println(n+1);
            System.out.print(Xc + " ");
            for(int i = 0 ; i < n ; i++) 
            System.out.print(1 + " ");
            System.out.println();
        }
        in.close();
    }
}