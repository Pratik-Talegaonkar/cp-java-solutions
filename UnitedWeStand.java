import java.util.ArrayList;
import java.util.Scanner;
public class UnitedWeStand {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
            }

            int max = Integer.MIN_VALUE;
            for(int a : arr) 
                max = Math.max(max,a);

            ArrayList<Integer> b = new ArrayList<>();
            ArrayList<Integer> c = new ArrayList<>();

            for(int a : arr) {
                if(a == max) {
                    c.add(a);
                }
                else {
                    b.add(a);
                }
            }

            if(b.size() == 0) {
                System.out.println(-1);
            }
            else {
                System.out.println(b.size() + " " + c.size());
                for(int a : b) {
                    System.out.print(a + " ");
                }
                System.out.println();
                for(int a : c) {
                    System.out.print(a + " ");
                }
            }
        }
        in.close();
    }
}