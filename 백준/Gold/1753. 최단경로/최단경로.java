import java.io.*;
import java.util.*;

public class Main {
	static List<int []> [] g;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		g = new List[V+1];
		for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, w});
		}
		boolean [] v = new boolean [V+1];
		int [] dist = new int [V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));

		pq.offer(new int[] {start, 0});
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			int node = cur[0];
			int cost = cur[1];
			v[node] = true;
			for (int []next: g[node]) {
				int next_node = next[0];
				int new_cost = next[1]+cost;
				if (!v[next_node]&&dist[next_node]>new_cost) {
					dist[next_node] = new_cost;
					pq.offer(new int[] {next_node, new_cost});
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (dist[i]!=Integer.MAX_VALUE) sb.append(dist[i]);
			else sb.append("INF");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}