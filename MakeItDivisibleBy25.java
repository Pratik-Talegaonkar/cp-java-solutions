import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class MakeItDivisibleBy25 {
	static int minOperations(String n, String possibleValue) {
		int operations = 0; 
		int checkerIndex = possibleValue.length() - 1;

		for (int i = n.length() - 1; i >= 0; i--) {
			if (n.charAt(i) == possibleValue.charAt(checkerIndex)) {
				checkerIndex--; 
				if (checkerIndex < 0)
					break;
			} else {
				operations++; 
			}
		}

		if (checkerIndex >= 0)
			operations = Integer.MAX_VALUE;

		return operations; 
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); 

		while (t-- > 0) {
			String n = scanner.next(); 

			List<String> possibleValues = Arrays.asList("00", "25", "50", "75");
			int ans = Integer.MAX_VALUE; 

			for (String possibleValue : possibleValues) {
				ans = Math.min(ans, minOperations(n, possibleValue)); 
			}

			System.out.println(ans); 
		}

		scanner.close();
	}
}