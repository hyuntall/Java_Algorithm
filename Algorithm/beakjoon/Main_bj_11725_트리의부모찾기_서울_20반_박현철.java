package a0307;
import java.io.*;
import java.util.*;
public class Main_bj_11725_트리의부모찾기_서울_20반_박현철 {

	static List<Integer>[] g;
	static int [] arr;
	static boolean [] v;
	static void dfs(int n) {
		v[n] = true;
		for (int a:g[n]) {
			if(v[a])continue;
			arr[a] = n;
			dfs(a);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		g = new List[N+1];
		arr = new int[N+1];
		v = new boolean[N+1];
		for (int i=1;i<=N;i++)g[i] = new ArrayList<>();
		for (int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		dfs(1);
		for (int i = 2; i <= N; i++)
			System.out.println(arr[i]);
	}
}
