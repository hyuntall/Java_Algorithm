package beakjoon;

import java.io.*;
import java.util.*;

public class problem14503로봇청소기 {
	static StringTokenizer st;
	static int N, M, r, c, d, result;
	static int arr[][];
	static int [] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static int [] dc = {0, 1, 0, -1};
	static void one(int r, int c, int d) {
		int nr, nc, nd;
		if (arr[r][c] == 0) {
			arr[r][c] = 2;
			result++;
		}
		boolean flag = false;
		int origin = d;
		for (int i = 0; i < 4; i++) {
			nd = (d + 3) % 4;
			nr = r + dr[nd];
			nc = c + dc[nd];
			if (0 <= nr && nr < N && 0 <= nc && nc < M
					&& arr[nr][nc] == 0) {
				one(nr, nc, nd);
				flag = true;
				break;
			}
			d = (d + 3) % 4;
		}
		if (!flag) { // 동서남북이 벽이거나 이미 청소했을 경우
			nd = (origin + 2) % 4;
			nr = r + dr[nd];
			nc = c + dc[nd];
			if (0 <= nr && nr < N && 0 <= nc && nc < M
					&& arr[nr][nc] != 1)
				one(nr, nc, origin);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		one(r, c, d);
		System.out.println(result);
	}
}
