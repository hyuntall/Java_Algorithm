import java.io.*;
import java.util.*;

public class Main {
	static int N, M, start, end;
	static List<int []>[] g;
	static int [] dist;
	static List<Integer>[] root;
	static boolean [] v;
	static void dijkstra(int start, int end) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)-> {
			if (o1[2]!=o2[2]) return -Integer.compare(o1[2], o2[2]);
			return Integer.compare(o1[1], o2[1]);
		});
		pq.offer(new int[] {start, 0, 0});
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int []cur = pq.poll();
			if (dist[cur[0]] < cur[1]) continue; 
			for(int []next : g[cur[0]]) {
				// 이미 제거된 간선 무시
				if (next[1]==-1)continue;
				if (dist[next[0]] > next[1] + cur[1]) {
					dist[next[0]] = next[1] + cur[1];
					// 더 짧은  경로 찾으면 기존 경로 삭제
					root[next[0]].clear();
					root[next[0]].add(cur[0]);
					pq.offer(new int[] {next[0], dist[next[0]], cur[2]+1});
				}
				else if (dist[next[0]] == next[1] + cur[1])
					root[next[0]].add(cur[0]); // 같은 거리의 경로라면 경로 추가
			}
		}
	}
	
	static void bfs(int x) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(x);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (v[cur]) continue;
			v[cur] = true;
			// 경로를 역추적하면서 거리 -1로 변경(삭제)
			for (int i = 0; i < root[cur].size(); i++) {
				int next = root[cur].get(i);
				for (int j = 0; j < g[next].size(); j++) {
					if (g[next].get(j)[0]==cur) g[next].get(j)[1] = -1;
				}
				q.offer(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N==0&&M==0)break;
			dist = new int[N];
			g = new List[N];
			root = new List[N];
			for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
			for (int i = 0; i < N; i++) root[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				g[U].add(new int[] {V, P});
			}
			Arrays.fill(dist, Integer.MAX_VALUE);
			// 최단경로  탐색
			dijkstra(start, end);
			v = new boolean[N];
			// 최단 경로들 삭제
			bfs(end);
			Arrays.fill(dist, Integer.MAX_VALUE);
			// 다음 최단 경로 탐색
			dijkstra(start, end);
			sb.append((dist[end]!=Integer.MAX_VALUE?dist[end]:-1) + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}