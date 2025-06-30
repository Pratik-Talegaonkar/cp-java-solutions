import java.util.Scanner;
public class EverybodyLikesGoodArrays {
    static boolean even(int a) {
        return a % 2 == 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int arr[] = new int[n];
            int count = 0;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
                if(i > 0) {
                    if(even(arr[i-1]) == even(arr[i])) {
                        count++;
                        arr[i] *= arr[i-1];
                    }
                }
            }

            System.out.println(count);
        }
        in.close();
    }
}