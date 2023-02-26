import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = Integer.MAX_VALUE, sum;
	static List<Integer>[] g;
	static int [] arr;
	static boolean []v, visited;
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static boolean isAble(int city, int cnt, boolean isA) {
		q.offer(city);
		visited[city] = true;
		while (!q.isEmpty()) {
			int n = q.poll();
			cnt--;
			for (int nCity: g[n]) {
				if (v[nCity] == isA && !visited[nCity]) {
					visited[nCity] = true;
					q.offer(nCity);
				}
			}
		}
		return (cnt == 0);
	}
	
	static void subs(int cnt, int aCnt) {
		if (ans == 0) return;
		if (cnt == N+1) {
			if (aCnt == N || aCnt == 0) return;
			
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N+1];
				if(v[i] && !isAble(i, aCnt, v[i])) return;
				if(!v[i]&&!isAble(i, N-aCnt, v[i])) return;
			}
			int aSum = 0;
			for (int i = 1; i <= N; i++) if(v[i])aSum+=arr[i];
			ans = Math.min(ans, Math.abs(sum-aSum-aSum));
			return;
		}
		v[cnt] = true;
		subs(cnt + 1, aCnt+1);
		v[cnt] = false;
		subs(cnt + 1, aCnt);
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
			sum+=arr[i];
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) g[i].add(Integer.parseInt(st.nextToken()));
		}
		subs(1, 0);
		System.out.println((ans!=Integer.MAX_VALUE)?ans:-1);
	}
}