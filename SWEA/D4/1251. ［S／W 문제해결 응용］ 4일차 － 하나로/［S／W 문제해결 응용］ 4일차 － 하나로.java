import java.io.*;
import java.util.*;

public class Solution {
    static List<Island>[] dist;
    static boolean v[];
    static class Island{
        int n;
        double len;
        public Island(int n, double len) {
            this.n = n;
            this.len = len;
        }
    }
 
    static double prim(int N) {
        PriorityQueue<Island> pq = new PriorityQueue<>((o1, o2)->Double.compare(o1.len, o2.len));
        pq.offer(new Island(0, 0.0));
        double total = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Island c = pq.poll();
            if(v[c.n]) continue;
            v[c.n] = true;
            total += c.len;
            if (cnt++ == N-1) break;
            for (Island next : dist[c.n]) 
                if (!v[next.n]) pq.offer(next);
        }
        return total;
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            dist = new List[N];
            v = new boolean[N];
            int [][] islands = new int[N][2];
             
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                islands[i][1] = Integer.parseInt(st.nextToken());   
                dist[i] = new ArrayList<Island>();
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                islands[i][0] = Integer.parseInt(st.nextToken());   
            }
            double E = Double.parseDouble(br.readLine());
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    int y2 = islands[i][1], y1 = islands[j][1];
                    int x2 = islands[i][0], x1 = islands[j][0];
                    double len = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
                    dist[i].add(new Island(j, E * len));
                    dist[j].add(new Island(i, E * len));
                }
            }
            sb.append("#"+t+" "+Math.round(prim(N))+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}