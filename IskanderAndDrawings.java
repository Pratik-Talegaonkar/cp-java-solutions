import java.util.Scanner;
public class IskanderAndDrawings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            int max = 0;
            int curr = 0;
            for(int i = 0 ; i < n ; i++) {
                if(s.charAt(i) == '#') {
                    curr++;
                    max = Math.max(curr,max);
                }
                else {
                    curr = 0;
                }
            }
            
            System.out.println((max % 2 == 0)? max/2 : max/2 + 1);
        }
        in.close();
    }
}
