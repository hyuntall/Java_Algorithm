import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans = 0;
	static int [][] arr, newArr;
	static int [] comb = new int [3];
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static List <int[]> virus = new ArrayList<>();
	
	static int count() {
		int sum = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++)
				if (newArr[i][j]==0)sum++;
		return sum;
	}
	
	static void dfs() {
		ArrayDeque<int []> q = new ArrayDeque<>();
		for (int [] v : virus) q.add(v);
		while (!q.isEmpty()) {
			int [] v = q.poll();
			int y = v[0], x = v[1];
			newArr[y][x] = 2;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (0<=ny&&ny<N&&0<=nx&&nx<M&&newArr[ny][nx]==0)
					q.add(new int[] {ny,nx});
			}
		}
	}
	
	static void comb(int cnt, int idx) {
		if (cnt == 3) {
			for (int i=0; i<N; i++) newArr[i]=Arrays.copyOf(arr[i], M);
			for(int i : comb) newArr[i/M][i%M] = 1;
			dfs();
			int area = count();
			ans = area>ans?area:ans;
			return;
		}
		for (int i=idx; i<N*M; i++) {
			if (arr[i/M][i%M]!=0) continue;
			comb[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		newArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
}