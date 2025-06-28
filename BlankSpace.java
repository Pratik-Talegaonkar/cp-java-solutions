import java.util.Scanner;
public class BlankSpace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int maxLength = 0;
            int tempLength = 0;
            for (int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt();
                if(arr[i] == 0) {
                    tempLength++;
                    maxLength = Math.max(maxLength,tempLength);
                }
                else {
                    maxLength = Math.max(maxLength,tempLength);
                    tempLength = 0;
                }
            }
            System.out.println(maxLength);
        }
        in.close();
    }
}
