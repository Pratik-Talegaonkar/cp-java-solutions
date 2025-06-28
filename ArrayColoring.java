import java.util.Scanner;
public class ArrayColoring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
                sum += arr[i];
            }
            if(sum % 2 == 0) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}