package a0309;

import java.io.*;
import java.util.*;


public class Main_bj_2206_벽부수고이동하기_서울_20반_박현철 {
	static int N, M;
	static int [][] arr;
	static boolean [][][] v;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int bfs() {
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0, 1});
		v[0][0][0] = true;
		while(!q.isEmpty()) {
			int []cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int crashed = cur[2];
			int len = cur[3];
			if (y == N-1 && x == M-1) return len;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<M) {
					if (arr[ny][nx]==0) {
						if (crashed==0 && !v[ny][nx][0]) {
							v[ny][nx][0] = true;
							q.offer(new int[] {ny, nx, crashed, len+1});
						}
						else if (crashed == 1 && !v[ny][nx][1]) {
							v[ny][nx][1] = true;
							q.offer(new int[] {ny, nx, crashed, len+1});
						}
					}
					else if (arr[ny][nx]==1 && crashed==0) {
						q.offer(new int[] {ny, nx, crashed+1, len+1});
						v[ny][nx][1] = true;
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) arr[i][j] = line.charAt(j)-'0';
		}
		System.out.println(bfs());
	}
}
