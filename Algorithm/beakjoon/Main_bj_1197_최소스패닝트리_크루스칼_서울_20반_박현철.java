package a0305;

import java.io.*;
import java.util.*;

public class Main_bj_1197_최소스패닝트리_크루스칼_서울_20반_박현철 {
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	static int V, E;
	static int [] p;
	static Edge [] edges;
	
	static void make() {
		p = new int[V+1];
		for (int i = 1; i <= V; i++) p[i] = i;
	}
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	static long kruskal() {
		long result = 0;
		int cnt = 0;
		for (Edge edge : edges) {
			// 두 간선이 싸이클이 형성되지 않았으면
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++cnt == V-1) break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edges);
		make(); // 각 노드 서로소 집합 생성
		// 크루스칼 알고리즘 최소 가중치 합 출력
		System.out.println(kruskal());
		br.close();
	}
}
