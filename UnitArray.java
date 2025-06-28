import java.util.Scanner;
public class UnitArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int negativeCount = 0;
            for(int i = 0 ; i < n ; i++) {
                int temp = in.nextInt();
                if(temp == -1)
                negativeCount++;
            }

            if(negativeCount - (n/2) > 0) {
                System.out.println(((negativeCount - (negativeCount - (n/2))) % 2 == 0) ? negativeCount - (n/2) : negativeCount - (n/2) + 1);
            }
            else {
                System.out.println((negativeCount % 2 == 0) ? 0 : 1);
            }
        }
        in.close();
    }
}
