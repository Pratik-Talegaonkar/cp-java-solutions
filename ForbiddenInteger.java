import java.util.*;

public class ForbiddenInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();

            if (x != 1) {
                // Use 1s, which is always safe
                System.out.println("YES");
                System.out.println(n);
                for (int i = 0; i < n; i++) {
                    System.out.print(1 + " ");
                }
                System.out.println();
            } else {
                // Cannot use 1
                if (k == 1) {
                    // Only 1 was allowed, and now it's banned → NO
                    System.out.println("NO");
                    continue;
                }

                if (k >= 2) {
                    if (n % 2 == 0) {
                        // Use 2s
                        System.out.println("YES");
                        System.out.println(n / 2);
                        for (int i = 0; i < n / 2; i++) {
                            System.out.print(2 + " ");
                        }
                        System.out.println();
                    } else {
                        // If k >= 3, use one 3 and rest 2s
                        if (k >= 3) {
                            System.out.println("YES");
                            System.out.println((n - 3) / 2 + 1);
                            System.out.print(3 + " ");
                            for (int i = 0; i < (n - 3) / 2; i++) {
                                System.out.print(2 + " ");
                            }
                            System.out.println();
                        } else {
                            // Cannot handle odd number with only 2s
                            System.out.println("NO");
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
