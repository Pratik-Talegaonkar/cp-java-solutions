import java.util.Scanner;
public class ServalAndMocha {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
            }

            boolean flag = false;
            for(int i = 0 ; i < n - 1 ; i++) {
                for(int j = i + 1 ; j < n ; j++) {
                    if(new ServalAndMocha().gcd(arr[i],arr[j]) <= 2) {
                        flag = true;
                    }
                }
            }

            System.out.println((flag)? "YES" : "NO");
        }
        in.close();
    }
    // Function to find greatest common divisor of two numbers
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}