import java.util.*;

public class MainakAndArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); 
		while (t-- > 0) {
			long n = scanner.nextLong(); 
			long[] v = new long[(int) n];
			for (int i = 0; i < n; i++) {
				v[i] = scanner.nextLong(); 
			}

			long answer = v[(int) n - 1] - v[0];

			for (int i = 1; i < n; i++) {
				answer = Math.max(answer, v[i] - v[0]);
			}

			for (int i = 0; i < n - 1; i++) {
				answer = Math.max(answer, v[(int) n - 1] - v[i]);
			}

			for (int i = 0; i < n - 1; i++) {
				answer = Math.max(answer, v[i] - v[i + 1]);
			}

			System.out.println(answer);
		}
		scanner.close();
	}
}