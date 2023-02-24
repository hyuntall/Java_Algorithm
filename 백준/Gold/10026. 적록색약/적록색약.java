import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char [][] arr;
	static boolean [][] v;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static void dfs(int y, int x, boolean RG) {
		v[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<=ny&&ny<N&&0<=nx&&nx<N&&!v[ny][nx]) {
				
				if (RG) {
					if (arr[y][x] == 'B' && arr[ny][nx] == 'B')
						dfs(ny, nx, RG);
					else if ((arr[y][x] == 'G' || arr[y][x] == 'R')&&(arr[ny][nx]=='G'||arr[ny][nx]=='R'))
						dfs(ny, nx, RG);
				} else {
					if (arr[y][x] == arr[ny][nx])
						dfs(ny, nx, RG);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String Line = br.readLine();
			for (int j = 0; j < N; j++) arr[i][j] = Line.charAt(j);
		}
		int ans1 = 0, ans2 = 0;
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j ++) {
				if (!v[i][j]) {
					dfs(i, j, false);
					ans1++;
				}
			}
		}
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j ++) {
				if (!v[i][j]) {
					dfs(i, j, true);
					ans2++;
				}
			}
		}
		System.out.println(ans1 + " " + ans2);
	}

}