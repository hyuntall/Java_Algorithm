package a0306;

import java.io.*;
import java.util.*;

public class Main_bj_1916_최소비용구하기_서울_20반_박현철 {
	static int N, M;
	static List<int[]>[]g;
	static int [] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int [N+1];
		g = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
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
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start, 0});
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		while (!pq.isEmpty()) {
			int cur [] = pq.poll();
			int city = cur[0];
			int cost = cur[1];
			if (city == end) break;
			for (int [] next: g[city]) {
				int n = next[0];
				int new_cost = next[1] + cost;
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
