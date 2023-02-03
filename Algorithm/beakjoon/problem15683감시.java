package beakjoon;

import java.io.*;
import java.util.*;

public class problem15683감시 {
	static int N, M, ans = Integer.MAX_VALUE, camCnt;
	static int [][]arr;
	static int [][]visited;
	static int comb[];
	static int [] dy = {0, 1, 0, -1}; // 좌하우상
	static int [] dx = {1, 0, -1, 0};
	static StringTokenizer st;
	static ArrayList<int []> list = new ArrayList<>();
	static void dfs(int y, int x, int dir) {
		int nx, ny;
		ny = y + dy[dir];
		nx = x + dx[dir];
		visited[y][x] = 1;
		if (0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] != 6) {
			dfs(ny, nx, dir);
		}
	}
	static void makeComb(int cnt, int idx) {
		int x, y, dir;
		if (cnt == camCnt) {
			visited = new int[N][M];
			for (int i = 0; i < camCnt; i++) {
				int [] a = list.get(i);
				x = a[1];
				y = a[0];
				dir = comb[i];
				dfs(y, x, dir);
				if (arr[y][x] == 2) dfs(y, x, (2+dir)%4);
				else if (arr[y][x] == 3) dfs(y, x, (3+dir)%4);
				else if (arr[y][x] == 4) {
					dfs(y, x, (2+dir)%4);
					dfs(y, x, (3+dir)%4);
				} else if (arr[y][x] == 5){
					dfs(y, x, (1+dir)%4);
					dfs(y, x, (2+dir)%4);
					dfs(y, x, (3+dir)%4);
				}
			}
			int result = 0;
			for (int ii = 0; ii < N; ii++) {
				for (int j = 0; j < M; j++) {
					if (visited[ii][j] == 0 && arr[ii][j] != 6) result++;
				}
			}
			if (ans > result) ans = result;
			return;
		}
		for (int i = 0; i < 4; i++) {
			comb[cnt] = i;
			makeComb(cnt+1, idx+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int n = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
				if (n > 0 && n < 6) {
					camCnt++;
					int [] xy = {i, j};
					list.add(xy);
				}
			}
		}
		comb = new int[camCnt];
		makeComb(0, 0);
		System.out.println(ans);
	}
}
