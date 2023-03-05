import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
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
	static List<Node>[] net;
	static boolean [] v;
	
	static int prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int total = 0;
		pq.offer(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (v[cur.to]) continue;
			v[cur.to] = true;
			total += cur.cost;
			for (Node next : net[cur.to]) 
				if (!v[next.to]) pq.offer(next);
		}
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		net = new ArrayList[N+1];
		v = new boolean[N+1];
		for (int i = 1; i <= N; i++) net[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			net[a].add(new Node(b, c));
			net[b].add(new Node(a, c));
		}
		System.out.println(prim());
	}
}