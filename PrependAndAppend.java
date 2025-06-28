import java.util.Scanner;
public class PrependAndAppend {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            int l = 0, r = n - 1;
            while (l < r && s.charAt(l) != s.charAt(r)) {
                l++;
                r--;
            }
            System.out.println(r - l + 1);
        }
        in.close();
    }
}