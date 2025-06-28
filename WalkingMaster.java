import java.util.Scanner;

public class WalkingMaster {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int source_x = in.nextInt();
            int source_y = in.nextInt();
            int destination_x = in.nextInt();
            int destination_y = in.nextInt();

            if (destination_y < source_y) {
                System.out.println(-1);
                continue;
            }

            int moves = destination_y - source_y;

            source_x += moves;

            if (source_x < destination_x) {
                System.out.println(-1);
                continue;
            }

            moves += (source_x - destination_x);

            System.out.println(moves);
        }
        in.close();
    }
}
