import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D, kill, ans;
	static int [][] arr, newArr;
	static int b [] = new int [3];
	static int [] dy = {0, -1, 0};
	static int [] dx = {-1, 0, 1};
	static boolean [][]v;
	static void bfs() {
		ArrayDeque<int []> q = new ArrayDeque<>();
		List<int []> kills = new ArrayList<>();
		for (int i : b) {
			v = new boolean[N+1][M];
			q.clear();
			q.offer(new int[] {N, i, 0});
			while (!q.isEmpty()) {
				int cur[] = q.poll();
				int y = cur[0];
				int x = cur[1];
				if (newArr[y][x] == 1) {
					kills.add(new int [] {y,x});
					break;
				}
				if (cur[2] == D) continue;
				for (int d = 0; d < 3; d++) {
					int ny = y+dy[d];
					int nx = x+dx[d];
					if (0<=ny&&ny<N&&0<=nx&&nx<M&&!v[ny][nx]) {
						v[ny][nx] = true;
						q.offer(new int[] {ny,nx, cur[2]+1});
					}
				}
			}
		}
		for (int e[]:kills) {
			int y = e[0], x = e[1];
			if (newArr[y][x] == 1) {
				kill++;
				newArr[y][x] = 0;
			}
		}
	}
	
	static boolean check() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				if (newArr[i][j] == 1) return false;
		return true;
	}
	static boolean enemyMove() {
		for (int i = N-1; i > 0; i--)
			for (int j = 0; j < M; j++)
				newArr[i][j] = newArr[i-1][j];

		for (int j = 0; j < M; j++) newArr[0][j] = 0;
		return true;
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == 3) {
			newArr = new int [N+1][M];
			for (int i=0; i<N; i++) newArr[i]=Arrays.copyOf(arr[i], M);
			kill = 0;
			while (true) {
				bfs();
				enemyMove();
				if (check()) break;
			}
			ans = Math.max(ans, kill);
			return;
		}
		for (int i=idx; i<M; i++) {
			b[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int [N+1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		System.out.println(ans);
		br.close();
	}
}