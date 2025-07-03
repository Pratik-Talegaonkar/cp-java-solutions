import java.util.HashSet;
import java.util.Scanner;
public class Forked {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int xK = in.nextInt();
            int yK = in.nextInt();
            int xQ = in.nextInt();
            int yQ = in.nextInt();

            HashSet<String> queenSet = new HashSet<>();
            HashSet<String> kingSet = new HashSet<>();

            int[] dx = {a, a, -a, -a, b, b, -b, -b};
            int[] dy = {b, -b, b, -b, a, -a, a, -a};

            for (int i = 0; i < 8; i++) {
                queenSet.add((xQ + dx[i]) + "," + (yQ + dy[i]));
                kingSet.add((xK + dx[i]) + "," + (yK + dy[i]));
            }

            int count = 0;
            for (String pos : queenSet) {
                if (kingSet.contains(pos)) {
                    count++;
                }
            }

            System.out.println(count);
        }
        in.close();
    }
    
}