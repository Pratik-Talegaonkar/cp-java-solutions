import java.util.Scanner;

public class OddGrasshopper {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); 
		while (t-- > 0) {
			long start = scanner.nextLong(); 
			long jumps = scanner.nextLong(); 
			long finalPos; 

			if (jumps % 4 == 1) {
				finalPos = -jumps; 
			} else if (jumps % 4 == 2) {
				finalPos = 1; 
			} else if (jumps % 4 == 3) {
				finalPos = jumps + 1; 
			} else {
				finalPos = 0; 
			}

			if (start % 2 == 0) {
				finalPos = start + finalPos; 
			} else {
				finalPos = start - finalPos; 
			}

			System.out.println(finalPos);
		}
		scanner.close();
	}
}
