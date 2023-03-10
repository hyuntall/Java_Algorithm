package a0306;

import java.io.*;
import java.util.*;

public class Main_bj_1584_게임_서울_20반_박현철 {
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int N, M;
	static int [][] arr = new int[501][501];
	static boolean [][] v = new boolean[501][501];
	static int dijkstra() {
		PriorityQueue<int []> q= new PriorityQueue<>((o1, o2)->Integer.compare(o1[2], o2[2]));
		q.offer(new int[] {0, 0, 0});
		v[0][0] = true;
		arr[0][0] = 0;
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];
			int c = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0<=ny&&ny<=500&&0<=nx&&nx<=500&&arr[nx][ny]<2) {
					if (!v[nx][ny]) {
						v[nx][ny] = true;
						arr[nx][ny] += c;
						q.offer(new int[] {nx, ny, arr[nx][ny]});
					}
				}
			}
		}
		return arr[500][500];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			Math.min(Y1, Y2);
			for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); x++)
				for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); y++)
					arr[x][y] = 1;
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); x++) 
				for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); y++) 
					arr[x][y] = 2;
		}
		int ans = dijkstra();
		System.out.println(v[500][500]?ans:-1);
	}
}
