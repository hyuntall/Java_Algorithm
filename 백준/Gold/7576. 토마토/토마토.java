import java.io.*;
import java.util.*;

public class Main {
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayDeque<int []> q = new ArrayDeque<>();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==1) q.offer(new int[] {i, j});
			}
		}
		
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			int y = cur[0], x = cur[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<M&&arr[ny][nx]==0) {
					arr[ny][nx] = arr[y][x] + 1;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j]==0) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, arr[i][j]);
			}
		}
		
		System.out.println(ans - 1);
	}
}