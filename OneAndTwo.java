import java.util.Scanner;
public class OneAndTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int twoCount = 0;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
                twoCount += (arr[i] == 2)? 1 : 0;
            }

            if(twoCount % 2 != 0) {
                System.out.println(-1);
            }
            else if(twoCount != 0) {
                int k = 0;
                twoCount /= 2;//2
                while(twoCount != 0) {//2 2 1 2 1 2
                    if(arr[k++] == 2) {
                        twoCount--;// k == 1 , twoCount == 1
                    }
                }
                System.out.println(k);
            }
            else {
                System.out.println(1);
            }
        }
        in.close();
    }
}
