package a0306;

import java.io.*;
import java.util.*;

public class Main_bj_10282_해킹_서울_20반_박현철 {
	// b가 감염되면 후에 a도 감염됨
	static List<int[]> [] g;
	static int [] dist;
	static int n, d, c;
	static boolean [] v;
	static void dijkstra(int start) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1],o2[1]));
		pq.offer(new int[] {start, 0});
		//v[start] = true;
		dist[start] = 0;
		int total = 0, cnt = 0;
		while (!pq.isEmpty()) {
			int [] cur = pq.poll();
			int n = cur[0];
			int t = cur[1];
			if (v[n]) continue;
			v[n] = true;
			total = t;
			for (int next[]:g[n])
				if (!v[next[0]]) {
					int cost = t+next[1];
					if (dist[next[0]] > cost) {
						dist[next[0]] = cost;
						pq.offer(new int[] {next[0], cost});
					}
				}
			cnt++;
		}
		System.out.println(cnt + " " + total);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			g = new ArrayList[n+1];
			v = new boolean[n+1];
			for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				g[b].add(new int [] {a, s});
			}
			dijkstra(c);
		}
	}
}
