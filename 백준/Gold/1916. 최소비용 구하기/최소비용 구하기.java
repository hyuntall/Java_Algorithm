import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<int []>[] g;
	static int dist[];
	static boolean v[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		g = new List[N+1];
		dist = new int[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<int[]>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, cost});
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dist[start] = 0;
		int cost, current;
		//System.out.println(Arrays.toString(dist));
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],  o2[1]));
		
		pq.offer(new int [] {start, 0});
		
		while (!pq.isEmpty()) {
			// step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			int cur [] = pq.poll();
			current = cur[0];
			cost = cur[1];
			
			if (current == -1) break;
			v[current] = true;
			if (current == end) break;
			for (int [] next: g[current]) {
				int n = next[0];
				int new_cost = next[1]+cost;
				if (dist[n] > new_cost) {
					dist[n] = new_cost;
					pq.offer(new int[] {n, new_cost});
				}
			}
		}
		System.out.println(dist[end]);
		br.close();
	}
}