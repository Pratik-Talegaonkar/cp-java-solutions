import java.util.*;

public class SequenceGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();  // number of test cases

        while (t-- > 0) {
            int n = in.nextInt();  // length of b
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            List<Integer> a = new ArrayList<>();
            a.add(b[0]);

            for (int i = 1; i < n; i++) {
                if (b[i] < b[i - 1]) {
                    a.add(1); // inserting a small number to break the chain
                }
                a.add(b[i]);
            }

            System.out.println(a.size());
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
