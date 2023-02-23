import java.io.*;
import java.util.*;

public class Main_bj_1697_숨바꼭질_서울_20반_박현철 {
	static int N, K;
	static int [] dx = {0, -1, 1};
	static int [] v = new int[1000001];

	static boolean bfs(int n, int cnt) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(n);
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K) {
				System.out.println(v[x]);
				break;
			}
			for (int nx:new int []{x+1, x-1, x*2}) {
				if (0<=nx&&nx<=1000000&&v[nx]==0) {
					q.offer(nx);
					v[nx] = v[x]+1;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs(N, 0);
	}
}
