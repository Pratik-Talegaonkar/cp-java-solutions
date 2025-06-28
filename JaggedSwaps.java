import java.util.*;

public class JaggedSwaps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.nextLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            if(in.hasNextLine()) in.nextLine();

            if(arr[0] == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
