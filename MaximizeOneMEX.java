import java.util.Arrays;
import java.util.Scanner;

public class MaximizeOneMEX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int bestVal = getKthMex(a, k);
            int ansI = -1;
            int ansJ = -1;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // Perform swap
                    swap(a, i, j);
                    
                    int currentVal = getKthMex(a, k);
                    if (currentVal > bestVal) {
                        bestVal = currentVal;
                        ansI = i + 1; // Convert to 1-based indexing
                        ansJ = j + 1;
                    }

                    // Undo swap
                    swap(a, i, j);
                }
            }

            if (ansI == -1) {
                System.out.println("-1");
            } else {
                System.out.println(ansI + " " + ansJ);
            }
        }
        in.close();
    }

    private static int getKthMex(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n];
        boolean[] present = new boolean[n + 1];
        int currentMex = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) {
                present[arr[i]] = true;
            }
            while (present[currentMex]) {
                currentMex++;
            }
            f[i] = currentMex;
        }

        Arrays.sort(f);
        // k-th largest element is at index (n - k) in ascending sorted order
        return f[n - k];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}