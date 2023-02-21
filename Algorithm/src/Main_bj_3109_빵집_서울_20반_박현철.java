import java.io.*;
import java.util.*;

public class Main_bj_3109_빵집_서울_20반_박현철 {
	static int R, C;
	static int [][] arr;
	static int [] dy = {-1, 0, 1};
	static int [] dx = {1, 1, 1};
	static boolean dfs(int y, int x) {
		arr[y][x] = 2;
		if (x == C-1) return true;
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < R && x < C && arr[ny][nx] == 0)
				if (dfs(ny, nx)) return true;
		}
		return false;
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
				if (line.charAt(j) == 'x')
					arr[i][j] = 1;
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++)
			if (dfs(i, 0))ans++;
		System.out.println(ans);
	}
}
