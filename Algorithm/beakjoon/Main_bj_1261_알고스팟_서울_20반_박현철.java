package a0306;

import java.io.*;
import java.util.*;

public class Main_bj_1261_알고스팟_서울_20반_박현철 {
	// NxM 크기
	// 상우하좌
	// 
	static int N, M;
	static int [][] arr, dp;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static void dijkstra() {
		//PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[2], o2[2]));
		ArrayDeque<int []> pq = new ArrayDeque<>();
		pq.offer(new int [] {0, 0});
		boolean [][] v = new boolean[M][N];
		v[0][0] = true;
		while (!pq.isEmpty()) {
			int [] cur = pq.poll();
			int y = cur[0];
			int x = cur[1];
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=nx&&nx<N&&0<=ny&&ny<M) {
					if(!v[ny][nx]) {
						v[ny][nx] = true;
						dp[ny][nx] = dp[y][x] + arr[ny][nx];
						pq.offer(new int[] {ny, nx});
					}else if(dp[ny][nx] > dp[y][x] + arr[ny][nx]) {
						dp[ny][nx] = dp[y][x] + arr[ny][nx];
						pq.offer(new int[] {ny, nx});
					}
				}
			}
		}
		System.out.println(dp[M-1][N-1]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [M][N];
		dp = new int [M][N];
		for (int i = 0; i < M; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) arr[i][j] = line.charAt(j) - '0';
		}
		dijkstra();
	}
}
