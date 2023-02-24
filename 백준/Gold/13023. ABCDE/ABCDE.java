import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer>[] g;
	static boolean [] v;
	
	static boolean dfs(int n, int cnt) {
		if (cnt == 4) return true;
		v[n] = true;
		for (int i:g[n]) if (!v[i]&&dfs(i, cnt+1)) return true;
		v[n] = false;
		return false;
			
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new List[N];
		for (int i = 0; i < N; i++) g[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b); g[b].add(a);
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			if(dfs(i, 0)) ans = 1;
		}
		System.out.println(ans);
	}
}