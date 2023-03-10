package a0305;

import java.io.*;
import java.util.*;

public class Main_bj_1197_최소스패닝트리_프림_서울_20반_박현철2 {
	
	static class Edge implements Comparable<Edge> {
		int to, weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	static int V, E;
	static boolean [] v;
	static List<Edge>[] edges;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	static int prim() {
		pq.offer(new Edge(1, 0));
		int total = 0, cnt = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int node = cur.to;
			int cost = cur.weight;
			if(v[node]) continue; // 이미 방문했던 노드라면 continue;
			v[node] = true; // 노드 방문 처리
			total += cost;
			for (Edge edge : edges[node])
				if (!v[edge.to]) pq.offer(edge);
			if (++cnt == V) break;
		}
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new ArrayList[V+1];
		for (int i = 1; i <= V; i++)edges[i] = new ArrayList<>();
		v = new boolean[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
			edges[to].add(new Edge(from, weight));
		}
		System.out.println(prim());
		br.close();
	}
}
