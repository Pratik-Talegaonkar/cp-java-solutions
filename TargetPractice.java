import java.util.Scanner;

public class TargetPractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short t = in.nextShort();
        in.nextLine();
        while(t-- > 0) {
            int sum = 0;
            for(int i = 0 ; i < 10 ; i++) {
                String s = in.nextLine();
                for(int j = 0 ; j < 10 ; j++) {
                    if(s.charAt(j) == 'X') {
                        if(i > 3 && i < 6 && j > 3 && j < 6) {
                            sum += 5;
                        }
                        else if(i > 2 && i < 7 && j > 2 && j < 7) {
                            sum += 4;
                        }
                        else if(i > 1 && i < 8 && j > 1 && j < 8) {
                            sum += 3;
                        }
                        else if(i > 0 && i < 9 && j > 0 && j < 9) {
                            sum += 2;
                        }
                        else {
                            sum += 1;
                        }
                    }
                }
            }

            System.out.println(sum);
        }
        in.close();
    }
}
