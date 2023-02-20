import java.io.*;
import java.util.*;

public class Main_bj_16234_인구이동_서울_20반_박현철 {
	static int N, L, R, union, popSum;
	static int [][] arr, v;
	static boolean [][] moved;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static ArrayList<int []> un;
	static void dfs(int y, int x, int num) {
		union++;
		popSum += arr[y][x];
		v[y][x] = num;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<=ny&&ny<N&&0<=nx&&nx<N&&v[ny][nx] < num) {
				int gap = Math.abs(arr[y][x]-arr[ny][nx]);
				if (L<=gap&&gap<=R) {
					dfs(ny,nx,num);
				}
			}
		}
	}
	static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int [] data = un.get(v[i][j]-1);
				arr[i][j] = data[1]/data[0];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		while (true) {
			int num = 1;
			v = new int[N][N];
			un = new ArrayList<>();
			moved = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j]==0) {
						union = 0;
						popSum = 0;
						dfs(i,j,num++);
						un.add(new int[] {union, popSum});
					}
				}
			}
			if (num - 1 == N*N) break;
			move();
			cnt++;
		}
		System.out.println(cnt);
	}
}
