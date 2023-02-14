import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main_bj_17144_미세먼지안녕_서울_20반_박현철 {
	static int [][] arr;
	static int R, C;
	static int [][] bot = new int[2][];
	static final int [] dy = {-1, 0, 1, 0}; // 상우하좌
	static final int [] dx = {0, 1, 0, -1};
	static void diffusion() {
		ArrayDeque<int []> newDust = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int difCnt = 0;
				int difDust = arr[i][j];
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if (0 <= ny && ny < R && 0 <= nx && nx < C && arr[ny][nx] != -1) {
						newDust.add(new int [] {ny, nx, difDust / 5});
						difCnt++;
					}
				}
				arr[i][j] = difDust - (difDust / 5 * difCnt);
			}
		}
		while (!newDust.isEmpty()) {
			int [] yx = newDust.poll();
			arr[yx[0]][yx[1]] += yx[2];
		}
	}
		
	static void purityUp(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (ny == bot[0][0] && nx == bot[0][1]) {
			arr[y][x] = 0;
			return;
		}
		if (0 <= ny && ny <= bot[0][0] && 0 <= nx && nx < C) {
			if (!(y == bot[0][0] && x == bot[0][1]))
				arr[y][x] = arr[ny][nx];
			purityUp(ny, nx, d);
		}
		else purityUp(y, x, (d + 1) % 4);
	}
	
	static void purityDown(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (ny == bot[1][0] && nx == bot[1][1]) {
			arr[y][x] = 0;
			return;
		}
		if (bot[1][0] <= ny && ny < R && 0 <= nx && nx < C) {
			if (!(y == bot[1][0] && x == bot[1][1]))
				arr[y][x] = arr[ny][nx];
			purityDown(ny, nx, d);
		}
		else purityDown(y, x, (d + 3) % 4);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int pos = 0;
		arr = new int [R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) bot[pos++] = new int [] {i, j};
			}
		}
		for (int i = 0; i < T; i++) {
		diffusion();
		purityUp(bot[0][0], bot[0][1], 0);
		purityDown(bot[1][0], bot[1][1], 2);
		}
		int ans = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) 
				ans += arr[i][j];
		System.out.println(ans + 2);
	}
}
