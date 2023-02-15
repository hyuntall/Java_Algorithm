import java.io.*;
import java.util.*;
public class Solution_d4_1227_미로2_서울_20반_박현철 {
	static int [] start, goal;
	static boolean [][] v;
	static boolean able;
	static int [][] arr;
	static int dy [] = {-1, 1, 0, 0};
	static int dx [] = {0, 0, -1, 1};
	static void dfs(int cur[]) {
		if (cur[0] == goal[0] && cur[1] == goal[1]) {
			able = true;
			return;
		}
		v[cur[0]][cur[1]] = true;
		for (int i = 0; i < 4; i++) {
			int ny = cur[0] + dy[i];
			int nx = cur[1] + dx[i];
			if (0<ny&&ny<=100&&0<nx&&nx<=100&&!v[ny][nx]&&arr[ny][nx]!=1) {
				dfs(new int [] {ny, nx});
			}
		}
		v[cur[0]][cur[1]] = false;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			arr = new int [101][101];
			v = new boolean [101][101];
			able = false;
			ArrayDeque<int []> q = new ArrayDeque<>();
			int T = Integer.parseInt(br.readLine());
			for (int i = 1; i <= 100; i++) {
				String line = br.readLine();
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = line.charAt(j - 1) - '0';
					if (arr[i][j] == 2) start = new int [] {i, j};
					if (arr[i][j] == 3) goal = new int [] {i, j};
				}
			}
			dfs(start);
			sb.append("#" + t + " " + (able?1:0)+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
