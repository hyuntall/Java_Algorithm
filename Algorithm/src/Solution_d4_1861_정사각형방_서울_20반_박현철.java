import java.io.*;
import java.util.*;

public class Solution_d4_1861_정사각형방_서울_20반_박현철 {
	static final int [] dy = {-1, 1, 0, 0};
	static final int [] dx = {0, 0, -1, 1};
	static ArrayDeque<int []> q = new ArrayDeque<>();
	static int [][] arr;
	static int N, maxCnt, minAns;
	static boolean v [][];
	static void dfs(int y, int x, int c) {
		q.offer(new int [] {y, x, 1});
		while (!q.isEmpty()) {
			int cur [] = q.poll();
			y = cur[0];
			x = cur[1];
			v[y][x] = true;
			int cnt = cur[2];
			if (cnt > maxCnt) {
				maxCnt = cnt;
				minAns = c;
			}
			else if (cnt == maxCnt)
				minAns = minAns > c ? c : minAns;
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (0 <= ny && ny < N && 0 <= nx && nx < N && arr[ny][nx] == arr[y][x] + 1)
					q.offer(new int [] {ny, nx, cnt + 1});
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			v = new boolean [N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			maxCnt = 1;
			minAns = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (!v[i][j]) dfs(i, j, arr[i][j]);
			sb.append("#" + t + " " + minAns + " " + maxCnt + "\n");
		}
		br.close();
		System.out.println(sb);
	}
}
