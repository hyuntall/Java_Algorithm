import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int [] v = new int[100001];
	static void bfs(int n) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(n);
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K) {
				System.out.println(v[x]);
				break;
			}
			for (int nx:new int []{x+1, x-1, x*2}) {
				if (0<=nx&&nx<=100000&&v[nx]==0) {
					q.offer(nx);
					v[nx] = v[x]+1;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs(N);
	}
}