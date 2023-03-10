package a0308;

import java.io.*;
import java.util.*;

public class Main_bj_4386_별자리만들기_서울_20반_박현철 {
	
	static class star {
		int n;
		double dist;
		public star(int n, double dist) {
			this.n = n;
			this.dist = dist;
		}
	}
	
	static List<star>[] g;
	static int N;
	static double [][] arr;
	static boolean [] v;
	static double getDist(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}

	static double prim() {
		PriorityQueue<star> pq = new PriorityQueue<>((o1, o2)->Double.compare(o1.dist, o2.dist));
		pq.offer(new star(1, 0.0));
		double total = 0;
		while (!pq.isEmpty()) {
			star s = pq.poll();
			if(v[s.n]) continue;
			v[s.n]= true;
			total += s.dist;
			for (star next : g[s.n]) 
				if (!v[next.n]) 
					pq.offer(new star(next.n, next.dist));
		}
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new double[N+1][2];
		v = new boolean[N+1];
		g = new List[N+1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			arr[i][0] = x; arr[i][1] = y;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i==j) continue;
				double dist = getDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
				g[i].add(new star(j, dist));
			}
		}
		System.out.printf("%.2f", prim());
	}
}
