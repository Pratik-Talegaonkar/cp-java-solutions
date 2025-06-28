import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoremyPaint3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        outer :
        while (t-- > 0) {
            int n = in.nextInt();
            HashMap<Integer,Integer> uni = new HashMap<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if(uni.get(arr[i]) == null)
                uni.put(arr[i],1);
                else 
                uni.put(arr[i],uni.get(arr[i]) + 1);
            }
            if (uni.size() > 2) {
                System.out.println("NO");
            } else {
                for(Map.Entry<Integer,Integer> element : uni.entrySet()) {
                    if(element.getValue() < n/2) {
                        System.out.println("NO");
                        continue outer;
                    }
                }
                System.out.println("YES");
            }
        }
        in.close();
    }
}
