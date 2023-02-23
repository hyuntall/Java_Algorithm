import java.io.*;
import java.util.*;

public class Main_bj_1987_알파벳_서울_20반_박현철 {
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int [][] arr;
	static int R, C, ans = 0;
	static void dfs(int y, int x, int cnt, int n) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if (0<=ny&&ny<R&&0<=nx&&nx<C&&(n&1<<arr[ny][nx]) == 0)
				dfs(ny, nx, cnt+1, n | 1<<arr[ny][nx]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int [R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++)
				arr[i][j] = line.charAt(j)-'A';
		}
		dfs(0, 0, 1, 1 <<arr[0][0]);
		System.out.println(ans);
	}
}
