package a0305;

import java.io.*;
import java.util.*;

public class Main_bj_1647_도시분할계획_서울_20반_박현철 {
	// N은 최대 10만, M은 최대 100만, 간선이 많음 -> 프림
	
	static class Node implements Comparable<Node> {
		int to, cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}
	}
	
	static int N, M;
	static List<Node>[] loads;
	static boolean [] v;
	static int prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int total = 0, max = 0;
		pq.offer(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int next = cur.to;
			int cost = cur.cost;
			if (v[next]) continue;
			v[next] = true;
			max = Math.max(max, cost);
			total += cost;
			for (Node node : loads[next])
				if(!v[node.to]) pq.offer(node);
		}
		return total - max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		loads = new ArrayList[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) loads[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			loads[A].add(new Node(B, C));
			loads[B].add(new Node(A, C));
		}
		System.out.println(prim());
	}
}
