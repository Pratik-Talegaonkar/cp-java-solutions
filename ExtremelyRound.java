import java.util.Scanner;
public class ExtremelyRound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            String n = in.next();
            int count = 0;
            count += Integer.parseInt(n.charAt(0) + "");
            count += 9*(n.length() - 1);
            System.out.println(count);
        }
        in.close();
    }
}
