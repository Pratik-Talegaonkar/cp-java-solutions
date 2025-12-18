import java.util.Scanner;

public class Chemistry {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next(); 
            
            int freq[] = new int[26];
            for(int i = 0 ; i < n ; i++) {
                freq[s.charAt(i) - 'a'] += 1;
            }

            int oddCases = 0;
            for(int i : freq) {
                if(i % 2 != 0)
                    oddCases++;
            }
            
            if(k >= oddCases - 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
