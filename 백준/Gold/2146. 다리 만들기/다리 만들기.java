import java.io.*;
import java.util.*;

public class Main {
	static int N, ans = Integer.MAX_VALUE;
	static int [][] arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static boolean [][] v;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static boolean isEdge(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<=ny&&ny<N&&0<=nx&&nx<N&&arr[ny][nx]==0)
				return true;
		}
		return false;
	}
	
	static void mark(int y, int x) {
		q.clear();
		q.offer(new int[] {y, x});
		v[y][x] = true;
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			y = cur[0];
			x = cur[1];
			for (int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<N&&!v[ny][nx]&&arr[ny][nx]==1) {
					v[ny][nx] = true;	
					q.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	static void bfs(int y, int x) {
		q.clear();
		q.offer(new int[] {y, x, 0});
		v[y][x] = true;
		while (!q.isEmpty()) {
			int [] cur = q.poll();
			y = cur[0];
			x = cur[1];
			int dist = cur[2];
			for (int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<N&&!v[ny][nx]) {
					if (arr[ny][nx]==0) {
						v[ny][nx] = true;
						q.offer(new int[] {ny, nx, dist+1});
					} else {
						if (dist>0) {
							ans = Math.min(ans, dist);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j]==1&&isEdge(i, j)) {
					v = new boolean[N][N];
					mark(i, j);
					//for(boolean a[]:v)System.out.println(Arrays.toString(a));
					bfs(i, j);
				}
			}
		}
		System.out.println(ans!=Integer.MAX_VALUE?ans:0);
	}
}