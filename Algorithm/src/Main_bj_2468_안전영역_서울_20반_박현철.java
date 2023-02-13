import java.io.*;
import java.util.*;

public class Main_bj_2468_안전영역_서울_20반_박현철 {
	static boolean [][] v;
	static int N, maxCnt;
	static int arr[][];
	static final int [] dy = {-1, 1, 0, 0};
	static final int [] dx = {0, 0, 1, -1};
	static void dfs(int y, int x) {
		v[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < N && 0 <= nx && nx < N && !v[ny][nx] && arr[ny][nx] > 0)
				dfs(ny, nx);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxCnt = 0;
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ",  ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		for (int c = 0; c <= max; c++) {
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < N; j++) 
					if (arr[i][j] == c) arr[i][j] = 0;
			v = new boolean [N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && arr[i][j] > 0) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
		br.close();
	}
}
