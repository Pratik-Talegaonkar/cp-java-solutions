import java.util.Scanner;

public class MochaAndMath {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); 
		while (t-- > 0) {
			long n = scanner.nextLong(); 
			long[] a = new long[(int) n];
			for (int i = 0; i < n; i++) { 
				a[i] = scanner.nextLong();
			}

			long totalAnd = a[0]; 
			for (int i = 1; i < n; i++) { 
				totalAnd &= a[i];
			}

			System.out.println(totalAnd); 
		}
		scanner.close();
	}

}
