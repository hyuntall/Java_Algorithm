package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_1967_트리의지름_서울_20반_박현철 {
	static int N;
	static List<int[]>[] g;
	static boolean [] v;
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static int dfs(int n) {
		v[n] = true;
		int max = 0;
		for (int [] a:g[n]) {
			if (v[a[0]]) continue;
			max = Math.max(max, dfs(a[0])+a[1]);
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		g = new List[N+1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to, w});
			g[to].add(new int[] {from, w});
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			v = new boolean[N+1];
			ans = Math.max(ans, dfs(i));
		}
		System.out.println(ans);
	}
}
