import java.util.Scanner;
public class MakeItBeautiful {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int maxIdx = 0;
            int minIdx = 0;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
                if(arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
                if(arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
            }

            if(arr[maxIdx] == arr[minIdx]) {
                System.out.println("NO");
            }
            else {
                System.out.println("YES");
                System.out.print(arr[maxIdx] + " " + arr[minIdx] + " ");
                for (int i = 0; i < arr.length; i++) {
                    if(i == minIdx || i == maxIdx)
                    continue;
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            
        }
        in.close();
    }
}
