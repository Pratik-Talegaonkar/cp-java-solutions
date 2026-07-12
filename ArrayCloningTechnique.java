import java.util.HashMap;
import java.util.Scanner;

public class ArrayCloningTechnique {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            int max = 0;
            for(int i = 0 ; i < n ; i++) {
                a[i] = in.nextInt();
                map.put(a[i],map.getOrDefault(a[i], 0)+1);
                if(map.get(a[i]) > map.getOrDefault(max, 0)) {
                    max = a[i];
                }
            }

            int ans = n - map.get(max);
            
            int count = map.get(max);
            while(count < n) {
                ans++;
                count *= 2;
            }
            System.out.println(ans);
        }
        in.close();
    }
}
