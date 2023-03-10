package a0309;

import java.io.*;
import java.util.*;

public class Main_bj_2638_치즈_서울_20반_박현철 {
	static int N, M;
	static int [][] arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static boolean [][] v;
	static ArrayDeque<int []> q = new ArrayDeque<>();
	static void bfs(int y, int x) {
		q.offer(new int[] {y, x});
		v[y][x] = true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			y = cur[0];
			x = cur[1];
			arr[y][x] = -1;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<M&&!v[ny][nx]&&arr[ny][nx]==0) {
					v[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	static boolean melt(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<=ny&&ny<N&&0<=nx&&nx<M&&arr[ny][nx]==-1)cnt++;
			else if (0>ny||N<=ny||0>nx||M<=nx) cnt++;
			
		}
		return (cnt>1)?true:false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int chz;
		int ans = 0;
		bfs(0, 0);
		ArrayDeque<int []> q = new ArrayDeque<>();
		while (true) {
			chz = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j]>0) {
						if (melt(i, j))
							q.offer(new int [] {i, j});
						chz++;
					}
				}
			}
			while (!q.isEmpty()) {
				int chs[] = q.poll();
				bfs(chs[0], chs[1]);
			}
			if (chz==0) break;
			ans++;
		}
		System.out.println(ans);
	}
}
