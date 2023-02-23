import java.io.*;
import java.util.*;
public class Main_bj_1260_DFS와BFS_서울_20반_박현철 {
	static int N, M, V;
	static List<Integer>[] g;
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int i) {
		v[i] = true;
		sb.append(i + " ");
		for (int j : g[i]) if (!v[j]) dfs(j);
	}
	
	static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		v[i] = true;
		q.offer(i);
		while (!q.isEmpty()) {
			i = q.poll();
			sb.append(i + " ");
			for (int j : g[i]) {
				if (!v[j]) {
					v[j] = true;
					q.offer(j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		g = new List[N+1];
		for (int i = 0; i <= N; i++) g[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		for(List a:g)Collections.sort(a);
		v = new boolean[N+1];
		dfs(V);
		v = new boolean[N+1];
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
		br.close();
	}
}
