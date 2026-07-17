import java.util.Scanner;

public class ABBalance {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); 
		scanner.nextLine(); 
		while (t-- > 0) {
			String s = scanner.nextLine(); 
			int n = s.length(); 

			if (s.charAt(0) != s.charAt(n - 1)) {
				if (s.charAt(0) == 'a') {
					s = 'b' + s.substring(1);
				} else {
					// Otherwise, change it to 'a'
					s = 'a' + s.substring(1);
				}
			}

			System.out.println(s);
		}
		scanner.close();
	}
}
