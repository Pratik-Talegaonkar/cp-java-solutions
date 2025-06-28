import java.util.Scanner;
import java.util.Arrays;

public class HalloumiBoxes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
            }
            int[] arr2 = Arrays.copyOf(arr, n);
            Arrays.sort(arr2);

            if(Arrays.equals(arr, arr2) || k > 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        } 
        in.close();
    }
}