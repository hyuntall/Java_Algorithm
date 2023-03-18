import java.io.*;
import java.util.*;

public class Main {
	static List<int []>[] g;
	static int N, M, R, ans;
	static boolean [] v;
	static int [] dist;
	static int [] itemCnt;
	static void prim(int start) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			if (!v[cur[0]]) v[cur[0]] = true;
			for (int next[]:g[cur[0]]) {
				if (!v[next[0]] && dist[next[0]] > next[1] + cur[1]) {
					dist[next[0]] = next[1] + cur[1];
					pq.offer(new int [] {next[0], dist[next[0]]});
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) if (dist[i] <= M) max += itemCnt[i];
		ans = Math.max(ans, max);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		g = new List[N+1];
		itemCnt = new int[N+1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) itemCnt[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int range = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, range});
			g[to].add(new int[] {from, range});
		}
		for (int i = 1; i <= N; i++) {
			v = new boolean[N+1];
			dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			prim(i);
		}
		System.out.println(ans);
	}
}