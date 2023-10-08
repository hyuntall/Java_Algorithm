import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] arr;
	static boolean [][] v;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int ans = 0;
	static void dfs(int y, int x, int sum, int cnt) {
		if (cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;
			if (v[ny][nx]) continue;
			
			if (cnt == 2) {
				v[ny][nx] = true;
				dfs(y, x, sum+arr[ny][nx], cnt+1);
				v[ny][nx] = false;
			}
			
			v[ny][nx] = true;
			dfs(ny, nx, sum+arr[ny][nx], cnt+1);
			v[ny][nx] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		v = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				v[i][j] = false;
			}
		}
		System.out.println(ans);
	}
}