import java.util.*;

public class OddQueries {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); 
		while (t-- > 0) {
			long n = scanner.nextLong(); 
			long q = scanner.nextLong(); 
			long[] a = new long[(int) n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextLong(); 
			}

			long oldSum = 0;
			for (int i = 0; i < n; i++) {
				oldSum += a[i]; 
			}

			long[] prefixSum = new long[(int) n + 1];
			for (int i = 1; i <= n; i++) {
				prefixSum[i] = prefixSum[i - 1] + a[i - 1]; 
			}

			while (q-- > 0) {
				long l = scanner.nextLong(); 
				long r = scanner.nextLong(); 
				long k = scanner.nextLong(); 

				long sumToRemove = prefixSum[(int) r] - prefixSum[(int) l - 1];
				long sumToAdd = (r - l + 1) * k;
				long totalSum = oldSum - sumToRemove + sumToAdd;
				if (totalSum % 2 == 1) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		scanner.close();
	}
}

