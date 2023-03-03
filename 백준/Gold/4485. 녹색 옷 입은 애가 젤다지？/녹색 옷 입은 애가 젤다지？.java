import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int [][]arr;
	static int [][]dp;
	static boolean [][]v;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static ArrayDeque<int []> q = new ArrayDeque<>();
	static void bfs() {
		int y, x, ny, nx;
		q.offer(new int[] {0, 0});
		v[0][0] = true;
		dp[0][0] = arr[0][0];
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			y = cur[0];
			x = cur[1];
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<N) {
					if(!v[ny][nx]) {
						v[ny][nx] = true;
						dp[ny][nx] = dp[y][x] + arr[ny][nx];
						q.offer(new int[] {ny, nx});
					} else if (dp[ny][nx] > dp[y][x] + arr[ny][nx]) {
						dp[ny][nx] = dp[y][x] + arr[ny][nx];
						q.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1;(N = Integer.parseInt(br.readLine()))!= 0;t++) {
			arr = new int[N][N];
			dp = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) { 
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			bfs();
			sb.append("Problem "+t+": "+dp[N-1][N-1]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}