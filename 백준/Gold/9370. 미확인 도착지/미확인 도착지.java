import java.io.*;
import java.util.*;

public class Main {
	static int N, M, T;
	static int S, G, H;
	static List<int []>[] g;
	static int [] candidate;
	static PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
	static int [] dist;
	static int m;
	static int dijkstra(int start, int end) {
		pq.offer(new int[] {start, 0});
		for (int j = 1; j <= N; j++) dist[j] = Integer.MAX_VALUE;
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int cur[] = pq.poll();
			for (int next[]:g[cur[0]]) {
				if (dist[next[0]] > next[1]+cur[1]) {
					dist[next[0]] = next[1]+cur[1];
					pq.offer(new int[] {next[0], dist[next[0]]});
				}
			}
		}
		return dist[end];
	}
	

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int _ = 0; _ < t; _++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			g = new List[N+1];
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
			int gh = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				g[from].add(new int[] {to, d});
				g[to].add(new int[] {from, d});
				if ((from==G&&to==H) || (from==H&&to==G)) gh=d;
			}
			candidate = new int[t];
			dist = new int[N+1];
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for (int i = 0; i < T; i++) {
				int end = Integer.parseInt(br.readLine());
				int ans = dijkstra(S, G) + gh + dijkstra(H, end);
				int ans2 = dijkstra(S, H) + gh + dijkstra(G, end);
				int ans3 = dijkstra(S, end);
//				System.out.println(ans + " " + dijkstra(S, end) + ans2);
//				System.out.println(Arrays.toString(dist));
				if (ans==ans3 || ans2==ans3) q.offer(end);
			}
			while (!q.isEmpty()) sb.append(q.poll() + " ");
			sb.append("\n");
		}
		System.out.println(sb); // 2 - 1 = 1 // 1 - 3 = 3 // 3 - 6 = 2
		br.close();
	}
}