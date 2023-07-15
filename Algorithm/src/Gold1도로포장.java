import java.io.*;
import java.util.*;

public class Gold1도로포장 {
	static class Node{
		int city;
		long cost;
		int cnt;
		Node(int city, long cost, int cnt) {
			this.city = city;
			this.cost = cost;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Node> []g = new List[N+1];
		
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<Node>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new Node(to, cost, 0));
			g[to].add(new Node(from, cost, 0));
		}
		
		long [][] dist = new long[N+1][K+1];
		for (int i = 0; i <= N; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
		dist[1][0] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)->Long.compare(o1.cost, o2.cost));
		
		q.offer(new Node (1, 0, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int city = cur.city;
			Long cost = cur.cost;
			int cnt = cur.cnt;
			
			if (dist[city][cnt] < cost) continue;
			
			for (Node next:g[city]) {
				int next_city = next.city;
				Long new_cost = cost + next.cost;
				if (dist[next_city][cnt] > new_cost) {
					dist[next_city][cnt] = new_cost;
					q.offer(new Node(next_city, new_cost, cnt));
				}
				
				if (cnt < K && dist[next_city][cnt+1] > cost) {
					dist[next_city][cnt+1] = cost;
					q.offer(new Node(next_city, cost, cnt+1));
				}
			}
		}
		long ans = Long.MAX_VALUE;
		for (int i = 0; i <= K; i++) ans = Math.min(dist[N][i], ans);
		System.out.println(ans);
	}
}
