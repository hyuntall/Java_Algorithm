package a0307;

import java.io.*;
import java.util.*;

public class Main_bj_1167_트리의지름_서울_20반_박현철 {
	static List<int []>[] g;
	static boolean [] v;
	static int ans;
	static int dfs(int i, int w) {
		v[i] = true;
		int [] b = new int[2];
		for (int a[]:g[i]) {
			if(v[a[0]])continue;
			b[0] = Math.max(b[0], dfs(a[0], a[1]));
			Arrays.sort(b);
		}
		ans = Math.max(ans, b[0]+b[1]);
		return b[1] + w;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		g = new List[V+1];
		v= new boolean[V+1];
		for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) break;
				int w = Integer.parseInt(st.nextToken());
				g[from].add(new int[] {to, w});
			}
		}
		dfs(1, 0);
		System.out.println(ans);
	}
}
