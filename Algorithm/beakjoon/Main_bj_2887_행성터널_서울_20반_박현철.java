package a0308;

import java.io.*;
import java.util.*;

public class Main_bj_2887_행성터널_서울_20반_박현철 {
	static int N;
	static List <Star> g;
	static int [] p;
	static int [][] X, Y, Z;
	static class Star implements Comparable<Star> {
		int from, to, w;
		
		public Star(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Star o) {
			return Integer.compare(w, o.w);
		}
	}
	
	static void make() {
		p = new int [N];
		for (int i = 1; i < N; i++) p[i] = i;
	}
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot==bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	static int kruskal() {
		int result = 0;
		int cnt = 0;
		for (Star star : g) {
			if (union(star.from, star.to)) {
				result += star.w;
				if (++cnt == N-1) break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		g = new ArrayList<>();
		X = new int[N][2]; Y = new int[N][2]; Z = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			X[i][0]=i; X[i][1] = Integer.parseInt(st.nextToken());
			Y[i][0]=i; Y[i][1] = Integer.parseInt(st.nextToken());
			Z[i][0]=i; Z[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(X, (o1, o2)->Integer.compare(o1[1], o2[1]));
		Arrays.sort(Y, (o1, o2)->Integer.compare(o1[1], o2[1]));
		Arrays.sort(Z, (o1, o2)->Integer.compare(o1[1], o2[1]));
		for (int i = 0; i < N - 1; i++) {
			g.add(new Star(X[i][0], X[i+1][0], Math.abs(X[i][1]-X[i+1][1])));
			g.add(new Star(Y[i][0], Y[i+1][0], Math.abs(Y[i][1]-Y[i+1][1])));
			g.add(new Star(Z[i][0], Z[i+1][0], Math.abs(Z[i][1]-Z[i+1][1])));
		}
		make();
		Collections.sort(g);
		System.out.println(kruskal());
	}
}
