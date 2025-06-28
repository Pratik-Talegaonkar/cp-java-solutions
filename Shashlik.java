import java.util.Scanner;

public class Shashlik {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int k = in.nextInt(); 
            int a = in.nextInt(); 
            int b = in.nextInt(); 
            int x = in.nextInt(); 
            int y = in.nextInt(); 

            int maxCount = 0;

            int countAFirst = 0;
            if (k >= a) {
                int maxA = ((k - a) / x) + 1;
                int remaining = k - maxA * x;
                countAFirst += maxA;
                if (remaining >= b) {
                    int maxB = ((remaining - b) / y) + 1;
                    countAFirst += maxB;
                }
            }

            int countBFirst = 0;
            if (k >= b) {
                int maxB = ((k - b) / y) + 1;
                int remaining = k - maxB * y;
                countBFirst += maxB;
                if (remaining >= a) {
                    int maxA = ((remaining - a) / x) + 1;
                    countBFirst += maxA;
                }
            }

            maxCount = Math.max(countAFirst, countBFirst);
            System.out.println(maxCount);
        }

        in.close();
    }
}
