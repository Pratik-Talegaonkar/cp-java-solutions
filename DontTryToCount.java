import java.util.Scanner;
public class DontTryToCount {
    static boolean check(String s, String x) {
        if (x.length() < s.length()) {
            return false;
        }
        for (int i = 0; i <= x.length() - s.length(); i++) {
            if (x.substring(i, i + s.length()).equals(s)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            //int n = in.nextInt();
            //int m = in.nextInt();
            in.nextLine(); 
            String x = in.nextLine();
            String s = in.nextLine();
            
            int count = 0;
            String curr = x;
            boolean possible = false;
            while (count <= 6) {
                if (check(s, curr)) {
                    possible = true;
                    break;
                }
                curr += curr;
                count++;
            }
            
            System.out.println(possible ? count : -1);
        }
        in.close();
    }
}