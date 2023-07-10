import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int [][] pool, water;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static ArrayDeque<int[]> q =  new ArrayDeque<>();
	
	static void dfs(int y, int x, int h, boolean [][] v) {
		q.offer(new int[] {y, x});
		v[y][x] = true;
		
		while (!q.isEmpty()) {
			int [] cur = q.pollLast();
			water[cur[0]][cur[1]]--;
			
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (v[ny][nx]) continue;
				
				if (ny == 0 || ny == N - 1 || nx == 0 || nx == M - 1) continue;
				
				if (pool[ny][nx] + water[ny][nx] == h && water[ny][nx] > 0) {
					q.offer(new int[] {ny, nx});
					v[ny][nx] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pool = new int [N][M]; water = new int[N][M];
		
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) { 
				pool[i][j] = line.charAt(j) - '0';
				maxHeight = Math.max(pool[i][j], maxHeight);
			}
		}
		
		for (int i = 1; i < N - 1; i++) 
			for (int j = 1; j < M - 1; j++)
				water[i][j] = maxHeight - pool[i][j];
		
		for (int h = maxHeight; h > 0; h--) {
			boolean v [][] = new boolean[N][M];
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (water[i][j] > 0 && !v[i][j]) {
						for (int d = 0; d < 4; d++) {
							int ny = dy[d] + i;
							int nx = dx[d] + j;
							if (water[ny][nx] + pool[ny][nx] < water[i][j] + pool[i][j]) {
								dfs(i, j, h, v);
								break;
							}
						}
					}
				}
			}
		}

		int ans = 0;
		for (int i = 1; i < N - 1; i++)
			for (int j = 1; j < M - 1; j++)
				ans += water[i][j];
		System.out.println(ans);
	}
}