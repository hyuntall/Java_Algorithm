import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] dist;
	static List<int []>[] g;
	static void dijkstra(int start, int end) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start, 0});
		dist[start][0] = 0;
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			if (cur[0] == end) return;
			for (int next[]: g[cur[0]]) {
				if (dist[next[0]][0] > next[1] + cur[1]) {
					dist[next[0]][0] = next[1] + cur[1];
					dist[next[0]][1] = cur[0];
					pq.offer(new int[] {next[0], dist[next[0]][0]});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		g = new List[N+1];
		dist = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			dist[i][0] = Integer.MAX_VALUE;
			g[i] = new ArrayList<>();
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, cost});
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start, end);
		System.out.println(dist[end][0]);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		while (end != 0) {
			stack.offer(end);
			end = dist[end][1];
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) System.out.print(stack.pollLast()+" ");
	}
}