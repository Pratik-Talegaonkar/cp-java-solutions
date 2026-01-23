import java.util.*;
import java.io.*;

public class TheCurseOfTheFrog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            
            long base = 0;
            long maxGain = Long.MIN_VALUE;
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                long a = Long.parseLong(st.nextToken());
                long b = Long.parseLong(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                
                base += (b - 1) * a;
                
                long gain = b * a - c;
                maxGain = Math.max(maxGain, gain);
            }
            
            if (base >= x) {
                sb.append(0).append("\n");
            } else if (maxGain <= 0) {
                sb.append(-1).append("\n");
            } else {
                long need = x - base;
                long r = (need + maxGain - 1) / maxGain;
                sb.append(r).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
