import java.util.*;

public class Desort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while (t-- > 0) {
            int n = sc.nextInt();
            int prev = sc.nextInt(); 
            boolean alreadyUnsorted = false;
            int minDiff = Integer.MAX_VALUE;

            for (int i = 1; i < n; i++) {
                int curr = sc.nextInt();

                if (prev > curr) {
                    alreadyUnsorted = true;  
                } else {
                    minDiff = Math.min(minDiff, curr - prev);
                }

                prev = curr;
            }
            if (alreadyUnsorted) {
                System.out.println(0);
            } else {//fsdfsdfsdfsdfsdf
                System.out.println((minDiff / 2) + 1);
            }
        }

        sc.close();
    }
}
