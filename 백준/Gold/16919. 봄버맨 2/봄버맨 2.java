import java.io.*;
import java.util.*;

public class Main {
	
	static class bomb{
		int time, y, x;
		boolean isbomb;
		public bomb(int time, int y, int x, boolean isbomb) {
			this.time = time;
			this.y = y;
			this.x = x;
			this.isbomb = isbomb;
		}
	}
	static int R, C, N;
	static bomb [][] arr;
	static int [] dy = {0, -1, 1, 0, 0};
	static int [] dx = {0, 0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<bomb> q = new ArrayDeque<>();
	static void n1() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j].isbomb) sb.append("O");
				else sb.append(".");
			}
			sb.append("\n");
		}
	}
	
	static void n2() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) sb.append("O");
			sb.append("\n");
		}
	}
	static void n3() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j].isbomb) {
					q.offer(arr[i][j]);
				}
			}
		}
		while (!q.isEmpty()) {
			bomb b = q.poll();
			int y = b.y, x = b.x;
			for (int i = 0; i < 5; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (0<=ny&&ny<R&&0<=nx&&nx<C) {
					arr[ny][nx].isbomb = true;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j].isbomb) sb.append(".");
				else sb.append("O");
			}
			sb.append("\n");
		}
	}
	
	static void n4() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j].isbomb) {
					q.offer(arr[i][j]);
				}
			}
		}
		while (!q.isEmpty()) {
			bomb b = q.poll();
			int y = b.y, x = b.x;
			for (int i = 0; i < 5; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (0<=ny&&ny<R&&0<=nx&&nx<C) {
					arr[ny][nx].isbomb = true;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!arr[i][j].isbomb) {
					q.offer(arr[i][j]);
				}
			}
		}
		while (!q.isEmpty()) {
			bomb b = q.poll();
			int y = b.y, x = b.x;
			for (int i = 0; i < 5; i++) {
				int ny = y + dy[i], nx = x + dx[i];
				if (0<=ny&&ny<R&&0<=nx&&nx<C) {
					arr[ny][nx].isbomb = false;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j].isbomb) sb.append("O");
				else sb.append(".");
			}
			sb.append("\n");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new bomb[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if (line.charAt(j)=='O') arr[i][j] = new bomb(3, i, j, true);
				else arr[i][j] = new bomb(0, i, j, false);
			}
		}
		if (N==1) n1();
		else if (N%2==0) n2();
		else if (N%4==3) n3();
		else if (N%4==1) n4();
		System.out.println(sb);
		br.close();
	}
}