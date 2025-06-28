import java.util.Scanner;

public class FalseAlarm {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine()); 
        
        outer:
        while(t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            in.nextLine(); 
            
            int first1 = -1;
            int[] arr = new int[n];
            
            for(int i = 0 ; i < n ; i++) {
                arr[i] = in.nextInt(); 
                if(first1 == -1 && arr[i] == 1) {
                    first1 = i;
                }
            }
            
            for(int i = first1 + x ; i < n ; i++) {
                if(arr[i] == 1) {
                    System.out.println("NO");
                    continue outer; 
                }
            }
            System.out.println("YES");
        }
        in.close();
    }
}
