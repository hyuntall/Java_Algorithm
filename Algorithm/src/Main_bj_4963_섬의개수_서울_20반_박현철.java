import java.io.*;
import java.util.*;

public class Main_bj_4963_섬의개수_서울_20반_박현철 {
	static int h, w;
	static int [][] arr;
	static boolean [][] v;
	static int [] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int [] dx = {0, 0, -1, 1, -1, 1, 1, -1};
	
	static void bfs(int y, int x) {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.add(new int [] {y, x});
		v[y][x] = true;
		while (!q.isEmpty()) {
			int cur [] = q.poll();
			y = cur[0];
			x = cur[1];
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<h&&0<=nx&&nx<w&&!v[ny][nx]&&arr[ny][nx]==1) {
					v[ny][nx] = true;
					q.add(new int[] {ny,nx});
				}
			}
		}
	}
	
	static void dfs(int y, int x) {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.add(new int [] {y, x});
		v[y][x] = true;
		while (!q.isEmpty()) {
			int cur [] = q.pollLast();
			y = cur[0];
			x = cur[1];
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<h&&0<=nx&&nx<w&&!v[ny][nx]&&arr[ny][nx]==1) {
					v[ny][nx] = true;
					q.add(new int[] {ny,nx});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w==0&&h==0) break;
			arr = new int [h][w];
			v = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!v[i][j]&&arr[i][j]==1) {
						dfs(i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
