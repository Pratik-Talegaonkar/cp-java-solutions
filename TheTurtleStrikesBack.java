import java.util.*;
import java.io.*;

public class TheTurtleStrikesBack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n * m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    a[i * m + j] = Integer.parseInt(st.nextToken());
                }
            }

            out.println(solve(n, m, a));
        }

        out.flush();
        out.close();
        br.close();
    }

    private static long solve(int n, int m, int[] a) {
        int size = n * m;
        final long NEG_INF = Long.MIN_VALUE / 2;

        // DP Forward
        long[] dpF = new long[size];
        Arrays.fill(dpF, NEG_INF);
        dpF[0] = a[0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                if (dpF[idx] == NEG_INF)
                    continue;
                if (j + 1 < m)
                    dpF[idx + 1] = Math.max(dpF[idx + 1], dpF[idx] + a[idx + 1]);
                if (i + 1 < n)
                    dpF[idx + m] = Math.max(dpF[idx + m], dpF[idx] + a[idx + m]);
            }
        }

        long maxPathSum = dpF[size - 1];

        // DP Backward
        long[] dpB = new long[size];
        Arrays.fill(dpB, NEG_INF);
        dpB[size - 1] = a[size - 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int idx = i * m + j;
                if (dpB[idx] == NEG_INF)
                    continue;
                if (j - 1 >= 0)
                    dpB[idx - 1] = Math.max(dpB[idx - 1], dpB[idx] + a[idx - 1]);
                if (i - 1 >= 0)
                    dpB[idx - m] = Math.max(dpB[idx - m], dpB[idx] + a[idx - m]);
            }
        }

        // Essential nodes: on max path AND all paths go through it
        // Using dual random hashing for robustness
        long MOD1 = 1000000007L, MOD2 = 998244353L;
        long[] cntF1 = new long[size], cntF2 = new long[size];
        long[] cntB1 = new long[size], cntB2 = new long[size];

        cntF1[0] = cntF2[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                if (j + 1 < m && dpF[idx] + a[idx + 1] == dpF[idx + 1]) {
                    cntF1[idx + 1] = (cntF1[idx + 1] + cntF1[idx]) % MOD1;
                    cntF2[idx + 1] = (cntF2[idx + 1] + cntF2[idx]) % MOD2;
                }
                if (i + 1 < n && dpF[idx] + a[idx + m] == dpF[idx + m]) {
                    cntF1[idx + m] = (cntF1[idx + m] + cntF1[idx]) % MOD1;
                    cntF2[idx + m] = (cntF2[idx + m] + cntF2[idx]) % MOD2;
                }
            }
        }

        cntB1[size - 1] = cntB2[size - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int idx = i * m + j;
                if (j - 1 >= 0 && dpB[idx] + a[idx - 1] == dpB[idx - 1]) {
                    cntB1[idx - 1] = (cntB1[idx - 1] + cntB1[idx]) % MOD1;
                    cntB2[idx - 1] = (cntB2[idx - 1] + cntB2[idx]) % MOD2;
                }
                if (i - 1 >= 0 && dpB[idx] + a[idx - m] == dpB[idx - m]) {
                    cntB1[idx - m] = (cntB1[idx - m] + cntB1[idx]) % MOD1;
                    cntB2[idx - m] = (cntB2[idx - m] + cntB2[idx]) % MOD2;
                }
            }
        }

        long totalPaths1 = cntF1[size - 1], totalPaths2 = cntF2[size - 1];

        // Find essential nodes
        int[] essentialIdx = new int[size];
        Arrays.fill(essentialIdx, -1);
        int numEssential = 0;
        int[] essentials = new int[size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                if (dpF[idx] + dpB[idx] - a[idx] == maxPathSum) {
                    long prod1 = (cntF1[idx] * cntB1[idx]) % MOD1;
                    long prod2 = (cntF2[idx] * cntB2[idx]) % MOD2;
                    if (prod1 == totalPaths1 && prod2 == totalPaths2) {
                        essentialIdx[idx] = numEssential;
                        essentials[numEssential++] = idx;
                    }
                }
            }
        }

        if (numEssential == 0)
            return maxPathSum;

        // L[u]: last essential dominating u from start
        // R[u]: first essential post-dominating u towards end
        int[] L = new int[size];
        int[] R = new int[size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                if (essentialIdx[idx] != -1) {
                    L[idx] = essentialIdx[idx];
                } else {
                    int val = -1;
                    if (i > 0)
                        val = Math.max(val, L[idx - m]);
                    if (j > 0)
                        val = Math.max(val, L[idx - 1]);
                    L[idx] = val;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int idx = i * m + j;
                if (essentialIdx[idx] != -1) {
                    R[idx] = essentialIdx[idx];
                } else {
                    int val = numEssential;
                    if (i + 1 < n)
                        val = Math.min(val, R[idx + m]);
                    if (j + 1 < m)
                        val = Math.min(val, R[idx + 1]);
                    R[idx] = val;
                }
            }
        }

        // Bucket-based sweep: O(NM + K)
        // For each edge (u, v), it covers essential indices in (L[u], R[v])
        // We add path value dpF[u] + dpB[v] to range [L[u]+1, R[v]-1]

        @SuppressWarnings("unchecked")
        ArrayList<Long>[] addAt = new ArrayList[numEssential + 1];
        @SuppressWarnings("unchecked")
        ArrayList<Long>[] removeAt = new ArrayList[numEssential + 1];

        for (int i = 0; i <= numEssential; i++) {
            addAt[i] = new ArrayList<>();
            removeAt[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u = i * m + j;
                // Edge Right
                if (j + 1 < m) {
                    int v = u + 1;
                    int left = L[u] + 1;
                    int right = R[v] - 1;
                    if (left <= right && right < numEssential) {
                        long val = dpF[u] + dpB[v];
                        addAt[left].add(val);
                        removeAt[right + 1].add(val);
                    }
                }
                // Edge Down
                if (i + 1 < n) {
                    int v = u + m;
                    int left = L[u] + 1;
                    int right = R[v] - 1;
                    if (left <= right && right < numEssential) {
                        long val = dpF[u] + dpB[v];
                        addAt[left].add(val);
                        removeAt[right + 1].add(val);
                    }
                }
            }
        }

        // Use TreeMap as a multiset for sweep
        TreeMap<Long, Integer> activeSet = new TreeMap<>(Collections.reverseOrder());
        long[] maxAlt = new long[numEssential];
        Arrays.fill(maxAlt, NEG_INF);

        for (int k = 0; k < numEssential; k++) {
            for (long val : addAt[k]) {
                activeSet.merge(val, 1, Integer::sum);
            }
            for (long val : removeAt[k]) {
                int cnt = activeSet.get(val);
                if (cnt == 1)
                    activeSet.remove(val);
                else
                    activeSet.put(val, cnt - 1);
            }
            if (!activeSet.isEmpty()) {
                maxAlt[k] = activeSet.firstKey();
            }
        }

        // Calculate answer
        long ans = maxPathSum;
        for (int k = 0; k < numEssential; k++) {
            int idx = essentials[k];
            long val = a[idx];
            // If we flip this node
            long pathThrough = maxPathSum - 2 * val;
            long best = pathThrough;
            if (maxAlt[k] != NEG_INF) {
                best = Math.max(best, maxAlt[k]);
            }
            ans = Math.min(ans, best);
        }

        return ans;
    }
}
