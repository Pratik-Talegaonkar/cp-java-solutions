import java.util.*;

public class TableCut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc);
            }
        }
        sc.close();
    }

    static int[][] grid;
    static int[][] prefixSum;
    static int N, M, totalOnes;
    static boolean transposed;

    private static void solve(Scanner sc) {
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] tempGrid = new int[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tempGrid[i][j] = sc.nextInt();
                if (tempGrid[i][j] == 1)
                    count++;
            }
        }
        totalOnes = count;

        if (r < c) {
            transposed = true;
            N = c;
            M = r;
            grid = new int[N][M];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    grid[j][i] = tempGrid[i][j];
                }
            }
        } else {
            transposed = false;
            N = r;
            M = c;
            grid = tempGrid;
        }

        prefixSum = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                prefixSum[i][j + 1] = prefixSum[i][j] + grid[i][j];
            }
        }

        // DP with Intervals [min, max]
        int[] minDp = new int[M + 1];
        int[] maxDp = new int[M + 1];

        // Initialize Row 0
        minDp[0] = 0;
        maxDp[0] = 0;
        for (int j = 1; j <= M; j++) {
            minDp[j] = 0;
            maxDp[j] = 0;
        }

        for (int i = 1; i <= N; i++) {
            int[] nextMin = new int[M + 1];
            int[] nextMax = new int[M + 1];

            // Col 0: only from Top
            nextMin[0] = minDp[0];
            nextMax[0] = maxDp[0];

            for (int j = 1; j <= M; j++) {
                int valFromTop = prefixSum[i - 1][j];

                // Option 1: From Left (R move) -> value 0 added
                int minLeft = nextMin[j - 1];
                int maxLeft = nextMax[j - 1];

                // Option 2: From Top (D move) -> value valFromTop added
                int minTop = minDp[j] + valFromTop;
                int maxTop = maxDp[j] + valFromTop;

                // Combine
                nextMin[j] = Math.min(minLeft, minTop);
                nextMax[j] = Math.max(maxLeft, maxTop);
            }
            minDp = nextMin;
            maxDp = nextMax;
        }

        // Find best sum in range [minDp[M], maxDp[M]]
        long bestProd = -1;
        int bestSum = -1;

        int lower = minDp[M];
        int upper = maxDp[M];
        double target = totalOnes / 2.0;

        if (target >= lower && target <= upper) {
            int cand1 = (int) Math.floor(target);
            int cand2 = (int) Math.ceil(target);
            if (cand1 >= lower && cand1 <= upper) {
                long p = (long) cand1 * (totalOnes - cand1);
                if (p > bestProd) {
                    bestProd = p;
                    bestSum = cand1;
                }
            }
            if (cand2 >= lower && cand2 <= upper) {
                long p = (long) cand2 * (totalOnes - cand2);
                if (p > bestProd) {
                    bestProd = p;
                    bestSum = cand2;
                }
            }
        } else if (target < lower) {
            bestSum = lower;
            bestProd = (long) lower * (totalOnes - lower);
        } else {
            bestSum = upper;
            bestProd = (long) upper * (totalOnes - upper);
        }

        System.out.println(bestProd);

        // Reconstruct
        StringBuilder sb = new StringBuilder();
        getPath(0, 0, N, M, bestSum, sb);

        String res = sb.toString();
        if (transposed) {
            StringBuilder trans = new StringBuilder();
            for (char ch : res.toCharArray()) {
                trans.append(ch == 'D' ? 'R' : 'D');
            }
            System.out.println(trans.toString());
        } else {
            System.out.println(res);
        }
    }

    private static void getPath(int r1, int c1, int r2, int c2, int target, StringBuilder sb) {
        if (r1 == r2) {
            for (int k = c1; k < c2; k++)
                sb.append('R');
            return;
        }
        if (c1 == c2) {
            for (int k = r1; k < r2; k++)
                sb.append('D');
            return;
        }
        if (r2 - r1 == 1) {
            for (int k = c1; k <= c2; k++) {
                if (prefixSum[r1][k] == target) {
                    for (int x = c1; x < k; x++)
                        sb.append('R');
                    sb.append('D');
                    for (int x = k; x < c2; x++)
                        sb.append('R');
                    return;
                }
            }
            return;
        }

        int mid = (r1 + r2) / 2;

        // Forward DP: r1 to mid
        int[] minDesc = new int[c2 - c1 + 1];
        int[] maxDesc = new int[c2 - c1 + 1];
        // Init row r1 (relative 0) - all 0s implicitly

        for (int i = r1 + 1; i <= mid; i++) {
            int[] nextMin = new int[c2 - c1 + 1];
            int[] nextMax = new int[c2 - c1 + 1];

            // Col 0
            int valD = prefixSum[i - 1][c1];
            nextMin[0] = minDesc[0] + valD;
            nextMax[0] = maxDesc[0] + valD;

            for (int j = 1; j <= c2 - c1; j++) {
                int valTop = prefixSum[i - 1][c1 + j];

                int minL = nextMin[j - 1];
                int maxL = nextMax[j - 1];

                int minT = minDesc[j] + valTop;
                int maxT = maxDesc[j] + valTop;

                nextMin[j] = Math.min(minL, minT);
                nextMax[j] = Math.max(maxL, maxT);
            }
            minDesc = nextMin;
            maxDesc = nextMax;
        }

        // Backward DP: r2 to mid
        int[] minAsc = new int[c2 - c1 + 1];
        int[] maxAsc = new int[c2 - c1 + 1];

        for (int i = r2 - 1; i >= mid; i--) {
            int[] nextMin = new int[c2 - c1 + 1];
            int[] nextMax = new int[c2 - c1 + 1];

            // Col c2 (relative max index)
            int valD = prefixSum[i][c2];
            nextMin[c2 - c1] = minAsc[c2 - c1] + valD;
            nextMax[c2 - c1] = maxAsc[c2 - c1] + valD;

            for (int j = c2 - c1 - 1; j >= 0; j--) {
                int valBot = prefixSum[i][c1 + j];

                int minR = nextMin[j + 1];
                int maxR = nextMax[j + 1];

                int minB = minAsc[j] + valBot;
                int maxB = maxAsc[j] + valBot;

                nextMin[j] = Math.min(minR, minB);
                nextMax[j] = Math.max(maxR, maxB);
            }
            minAsc = nextMin;
            maxAsc = nextMax;
        }

        // Find merge point
        for (int j = 0; j <= c2 - c1; j++) {
            int rangeMin = target - maxDesc[j];
            int rangeMax = target - minDesc[j];

            int overlapMin = Math.max(rangeMin, minAsc[j]);
            int overlapMax = Math.min(rangeMax, maxAsc[j]);

            if (overlapMin <= overlapMax) {
                int v = overlapMin;
                int u = target - v;

                getPath(r1, c1, mid, c1 + j, u, sb);
                getPath(mid, c1 + j, r2, c2, v, sb);
                return;
            }
        }
    }
}
