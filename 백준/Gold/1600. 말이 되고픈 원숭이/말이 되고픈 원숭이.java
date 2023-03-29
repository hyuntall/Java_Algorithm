import java.io.*;
import java.util.*;

public class Main {
	static int W, H, ans = Integer.MAX_VALUE;
	static int [][] arr = new int[200][200], dp = new int[200][200];
	static boolean [][][] v = new boolean[200][200][31];
	static int [] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	static int [] hdy = {1, 2, 2, 1, -1, -2, -2, -1}, hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static void bfs(int K) {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		v[0][0][0] = true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0], x = cur[1], k = cur[2];
			if (y==H-1&&x==W-1) ans = Math.min(dp[y][x], ans);
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (0<=ny&&ny<H&&0<=nx&&nx<W&&arr[ny][nx]==0
				&& (!v[ny][nx][k]||dp[ny][nx]>dp[y][x]+1)) {
					v[ny][nx][k] = true;
					dp[ny][nx] = dp[y][x] + 1;
					q.offer(new int[] {ny, nx, k});
				}
			}
			if (k >= K) continue;
			for (int i = 0; i < 8; i++) {
				int ny = y + hdy[i], nx = x + hdx[i];
				if (0<=ny&&ny<H&&0<=nx&&nx<W&&arr[ny][nx]==0
				&& (!v[ny][nx][k+1]||dp[ny][nx]>dp[y][x]+1)) {
					v[ny][nx][k+1] = true;
					dp[ny][nx] = dp[y][x] + 1;
					q.offer(new int[] {ny, nx, k+1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs(K);
		System.out.println(ans!=Integer.MAX_VALUE?ans:-1);
	}
}