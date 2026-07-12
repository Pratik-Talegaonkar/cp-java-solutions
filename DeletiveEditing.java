import java.util.*;

public class DeletiveEditing {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long test = scanner.nextLong();
		scanner.nextLine(); 
		while (test-- > 0) {
			String s = scanner.next();
			String t = scanner.next();

			int n = s.length();
			int m = t.length();

			int[] frequencyInT = new int[26];
			for (int i = 0; i < m; i++) {
				frequencyInT[t.charAt(i) - 'A']++;
			}

			StringBuilder finalString = new StringBuilder();
			for (int i = n - 1; i >= 0; i--) {
				if (frequencyInT[s.charAt(i) - 'A'] > 0) {
					frequencyInT[s.charAt(i) - 'A']--;
					finalString.append(s.charAt(i));
				}
			}

			finalString.reverse();

			if (finalString.toString().equals(t)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();
	}
}