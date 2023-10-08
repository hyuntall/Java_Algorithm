import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [][] arr;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int [][] wall = new int[3][2];
	static int ans;
	static List<int []> initVirus = new ArrayList<int[]>();
	static ArrayDeque<int []> virus = new ArrayDeque<>();
	
	static int getArea(int [][] arr) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j]==0)sum++;
			}
		}
		return sum;
	}
	
	static void bfs(int [][] arr) {
		while (!virus.isEmpty()) {
			int [] cur = virus.poll();
			arr[cur[0]][cur[1]] = 2;
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				if (arr[ny][nx] != 0) continue;
				virus.offer(new int[] {ny, nx});
			}
		}
		
	}
	
	static void comb(int cnt, int index) {
		if (cnt == 3) {
			int [][] cpArr = new int[N][M];
			for (int i = 0; i < N; i++) cpArr[i] = Arrays.copyOf(arr[i], M);
			for (int i = 0; i < 3; i++) 
				cpArr[wall[i][0]][wall[i][1]] = 1;
			
			for (int [] v:initVirus) virus.offer(v);
			bfs(cpArr);
			ans = Math.max(ans, getArea(cpArr));
			return;
		}
		
		for (int i = index; i < N*M; i++) {
			if (arr[i/M][i%M] != 0) continue;
			wall[cnt][0] = i/M;
			wall[cnt][1] = i%M;
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) 
					initVirus.add(new int[] {i, j});
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
}