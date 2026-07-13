import java.util.Scanner;

public class MakeAP {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); 
		while (t-- > 0) {
			long a = scanner.nextLong(); 
			long b = scanner.nextLong(); 
			long c = scanner.nextLong(); 

			boolean answer = false; 

			long new_a = 2 * b - c; 
			if (new_a / a > 0 && new_a % a == 0) { 
				answer = true;
			}

			long new_b = (a + c) / 2; 
			if (new_b / b > 0 && new_b % b == 0 && (c - a) % 2 == 0) { 
				answer = true;
			}

			long new_c = 2 * b - a; 
			if (new_c / c > 0 && new_c % c == 0) { 
				answer = true;
			}

			if (answer) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();
	}
}