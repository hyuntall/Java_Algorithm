import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = Integer.MAX_VALUE, SUM;
	static List[] g;
	static int [] arr;
	static boolean []v, visited;
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static boolean isAble(int c, int cnt, boolean isA) {
		q.offer(c);
		visited[c] = true;
		while (!q.isEmpty()) {
			int n = q.poll();
			cnt--;
			for (int i = 0; i < g[n].size(); i++) {
				int a = (int) g[n].get(i);
				if (v[a] == isA && !visited[a]) {
					visited[a] = true;
					q.offer(a);
				}
			}
		}
		if (cnt > 0) return false;
		return true;
	}
	
	static void subs(int cnt, int a) {
		if (cnt == N+1) {
			if (a == N || a == 0) return;
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				if(v[i] && (!isAble(i, a, v[i]))) return;
				if(!v[i]&&!isAble(i, N-a, v[i]))return;
			}
			int sum = 0;
			for (int i = 1; i <= N; i++) if(v[i])sum+=arr[i];
			ans = Math.min(ans, Math.abs(SUM-sum-sum));
			return;
		}
		v[cnt] = true;
		subs(cnt + 1, a+1);
		v[cnt] = false;
		subs(cnt + 1, a);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		g = new List[N+1];
		arr = new int[N+1];
		v = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			SUM+=arr[i];
		}
		for (int from = 1; from <= N; from++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				g[from].add(to);
			}
		}
		subs(1, 0);
		System.out.println((ans!=Integer.MAX_VALUE)?ans:-1);
	}
}